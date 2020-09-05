package com.hmjang.kakaobook.data.remote.book

import com.google.gson.annotations.SerializedName

data class BookQueryModel(
    @SerializedName("meta") val page: PageModel,
    @SerializedName("documents") val documents: List<BookModel>
)