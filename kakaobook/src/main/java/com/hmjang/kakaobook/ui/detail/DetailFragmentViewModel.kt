package com.hmjang.kakaobook.ui.detail

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmjang.kakaobook.data.view.BookItemModel
import com.hmjang.kakaobook.ui.base.BaseViewModel

class DetailFragmentViewModel(bundle: Bundle?) : BaseViewModel() {

    val item: LiveData<BookItemModel> = MutableLiveData(bundle?.get("data") as BookItemModel)
    private val _onWarningMsg = MutableLiveData<String>()
    val onWarningMsg: LiveData<String> = _onWarningMsg

}