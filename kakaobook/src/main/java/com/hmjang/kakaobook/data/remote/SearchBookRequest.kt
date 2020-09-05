package com.hmjang.kakaobook.data.remote

import com.google.gson.JsonElement
import com.hmjang.kakaobook.KeyHolder
import com.hmjang.kakaobook.data.SearchQueryData
import com.hmjang.kakaobook.data.remote.base.BaseRequester
import io.reactivex.Flowable
import okhttp3.Headers

const val BASE_URL = "https://dapi.kakao.com"

class SearchBookRequest : BaseRequester<BookApi>() {

    override fun getApiClass() = BookApi::class.java

    override fun getBaseUrl() = BASE_URL

    override fun createHeaders(): Headers {
        return Headers.Builder()
            .add(
                "Content-Type",
                "application/json"
            )
            .add(
                "Authorization",
                "KakaoAK ${KeyHolder.getApiKey()}")
            .build()
    }

    fun searchBook(data: SearchQueryData): Flowable<JsonElement> {
        return getApi().searchBook(data.query, data.page, data.size)
    }

}