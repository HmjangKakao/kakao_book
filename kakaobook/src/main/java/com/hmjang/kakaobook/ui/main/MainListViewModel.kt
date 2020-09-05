package com.hmjang.kakaobook.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmjang.kakaobook.data.view.SearchQueryData
import com.hmjang.kakaobook.data.remote.book.BookModel
import com.hmjang.kakaobook.data.remote.book.BookQueryModel
import com.hmjang.kakaobook.data.remote.book.PageData
import com.hmjang.kakaobook.api.book.BookRequest
import com.hmjang.kakaobook.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject


class MainListViewModel : BaseViewModel() {

    val keyword = MutableLiveData<String>()
    private val publishSubject = PublishSubject.create<SearchQueryData>()
    private val searchBookRequest by lazy { BookRequest() }

    private val _page = MutableLiveData<PageData>()
    private val _items = MutableLiveData<MutableList<BookModel>>()
    val items: LiveData<MutableList<BookModel>> = _items
    private val _onWarningMsg = MutableLiveData<String>()
    val onWarningMsg: LiveData<String> = _onWarningMsg
    private var currentPage: SearchQueryData = SearchQueryData()

    init {
        setSearchBookRequest()
    }

    private fun setSearchBookRequest() {
        val disposable =
            publishSubject
                .distinctUntilChanged()
                .switchMapSingle { data ->
                    currentPage = data
                    searchBookRequest.searchBook(data)
                        .doOnSubscribe { showLoading() }
                        .doOnTerminate { hideLoading() }
                        .subscribeOn(Schedulers.io())
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BookQueryModel>() {
                    override fun onNext(t: BookQueryModel) {
                        _page.value = t.page
                        when (currentPage.page) {
                            1 -> {  _items.value = ArrayList(t.documents)   }
                            else -> {
//                                _items.value?.let { it.addAll(t.documents) }
                                _items.value = _items.value?.run {
                                    val list = ArrayList(this)
                                    list.addAll(t.documents)
                                    list
                                }
                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                        _onWarningMsg.value = "오류가 발생하였습니다. 잠시 후 시도해주세요.\n" + e.message
                    }

                    override fun onComplete() {

                    }
                })
        compositeDisposable.add(disposable)
    }

    fun requestMoreBooks() : Boolean {
        val isEnd = _page.value?.isEnd?.let { it } ?: true
        return if (isEnd.not()) {
            keyword.value?.let { keyword ->
                publishSubject.onNext(SearchQueryData(keyword, currentPage.page + 1))
                true
            } ?: false
        } else false
    }

    fun searchBook(queryKeyword: String) {
        publishSubject.onNext(SearchQueryData(queryKeyword))
    }

}
