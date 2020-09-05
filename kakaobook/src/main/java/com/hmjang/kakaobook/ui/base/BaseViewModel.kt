package com.hmjang.kakaobook.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    protected fun showLoading() {
        _isLoading.postValue(true)
    }

    protected fun hideLoading() {
        _isLoading.postValue(false)
    }

}