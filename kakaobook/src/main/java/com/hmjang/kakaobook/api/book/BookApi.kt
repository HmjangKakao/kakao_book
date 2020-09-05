package com.hmjang.kakaobook.api.book

import com.hmjang.kakaobook.data.remote.book.BookQueryModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("v3/search/book")
    fun searchBook(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Single<BookQueryModel>

}