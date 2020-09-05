package com.hmjang.kakaobook.ui.main

import androidx.lifecycle.MutableLiveData
import com.hmjang.kakaobook.data.SearchQueryData
import com.hmjang.kakaobook.data.remote.SearchBookRequest
import com.hmjang.kakaobook.data.remote.base.BaseRequester
import com.hmjang.kakaobook.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainListViewModel : BaseViewModel() {

    val queryKeyword = MutableLiveData<String>()
    private val searchQueryData = SearchQueryData()
    private var beforeQueryData = SearchQueryData()

    private val searchBookRequester by lazy { SearchBookRequest() }

    init {

    }

    fun searchBook(queryKeyword: String) {
        if (beforeQueryData != searchQueryData) {
            searchQueryData.query = if (queryKeyword.isBlank()) "" else queryKeyword
            beforeQueryData = searchQueryData.copy()
        }
    }

    fun requestSearchBook() {
//        val disposable = searchBookRequester.searchBook(searchQueryData).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//        compositeDisposable.add(disposable)
    }

}
