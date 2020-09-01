package com.hmjang.kakaobook.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    private val isLoading = MutableLiveData(false)
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    protected fun showLoading() {
        isLoading.postValue(true)
    }

    protected fun hideLoading() {
        isLoading.postValue(false)
    }

}