package com.hmjang.kakaobook.ui.main

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmjang.kakaobook.data.SearchQueryData
import com.hmjang.kakaobook.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.observable.ObservableDebounce
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_list_fragment.*
import java.util.concurrent.TimeUnit


class MainListViewModel : BaseViewModel() {

    val searchQueue = MutableLiveData<SearchQueryData>()

    init {
        observeEditText()
    }

    private fun observeEditText() {
        Observable.create { emitter: ObservableEmitter<String>? ->
            emitter?.onNext(searchQueue.value?.query)
        }
            .debounce(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .subscribe {
                Log.d("test", " search : $it")
            }
    }

}
