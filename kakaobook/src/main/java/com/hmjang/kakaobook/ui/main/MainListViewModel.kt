package com.hmjang.kakaobook.ui.main

import androidx.lifecycle.MutableLiveData
import com.hmjang.kakaobook.data.SearchQueryData
import com.hmjang.kakaobook.extension.then
import com.hmjang.kakaobook.ui.base.BaseViewModel


class MainListViewModel : BaseViewModel() {

    val queryKeyword = MutableLiveData<String>()
    private val searchQueryData = SearchQueryData()
    private var beforeQueryData = SearchQueryData()

    init {

    }

    fun searchBook(queryKeyword: String) {
        if (beforeQueryData != searchQueryData) {
            searchQueryData.query = if (queryKeyword.isBlank()) "" else queryKeyword
            beforeQueryData = searchQueryData.copy()
        }
    }

}
