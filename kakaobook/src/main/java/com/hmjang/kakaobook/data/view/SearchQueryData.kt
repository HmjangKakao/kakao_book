package com.hmjang.kakaobook.data.view

import com.google.gson.annotations.SerializedName

data class SearchQueryData(
    @SerializedName("query") var query: String = "",
    @SerializedName("page") var page: Int = 1,
    @SerializedName("size") var size: Int = 50,
)