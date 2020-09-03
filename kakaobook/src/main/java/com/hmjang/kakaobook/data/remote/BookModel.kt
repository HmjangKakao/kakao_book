package com.hmjang.kakaobook.data.remote

import com.google.gson.annotations.SerializedName

data class BookModel(
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("datetime") val datetime: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("price") val price: Int,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("sale_price") val sale_price: Int,
    @SerializedName("status") val status: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("url") val url: String,
    @SerializedName("authors") val authors: Array<String>,
    @SerializedName("translators") val translators: Array<String>
)