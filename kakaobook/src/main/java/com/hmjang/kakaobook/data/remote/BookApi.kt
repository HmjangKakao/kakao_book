package com.hmjang.kakaobook.data.remote

import com.google.gson.JsonElement
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("v3/search/book")
    fun searchBook(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Flowable<JsonElement>

}