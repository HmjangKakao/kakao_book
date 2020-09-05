package com.hmjang.kakaobook.data.remote.book

import com.google.gson.annotations.SerializedName

data class BookQueryModel(
    @SerializedName("meta") val page: PageData,
    @SerializedName("documents") val documents: List<BookModel>
)