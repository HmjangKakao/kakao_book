package com.hmjang.kakaobook.api.book

import com.hmjang.kakaobook.KeyHolder
import com.hmjang.kakaobook.data.view.SearchQueryData
import com.hmjang.kakaobook.api.base.BaseRequest
import com.hmjang.kakaobook.data.remote.book.BookQueryModel
import io.reactivex.Single
import okhttp3.Headers

const val BASE_URL = "https://dapi.kakao.com"

class BookRequest : BaseRequest<BookApi>() {

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
                "KakaoAK ${KeyHolder.getOriginalApiKey()}")
            .build()
    }

    fun searchBook(data: SearchQueryData): Single<BookQueryModel> {
        return getApi().searchBook(data.query, data.page, data.size)
    }

}