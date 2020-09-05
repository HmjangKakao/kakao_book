package com.hmjang.kakaobook.data.remote.book

import com.google.gson.annotations.SerializedName

data class PageData(
    @SerializedName("is_end") val isEnd: Boolean,
    @SerializedName("pageable_count") val count: Int,
    @SerializedName("total_count") val totalCount: Int
)