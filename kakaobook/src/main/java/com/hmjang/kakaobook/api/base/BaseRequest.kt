package com.hmjang.kakaobook.api.base

import okhttp3.Headers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT_SECONDS = 60L

abstract class BaseRequest<T> {

    protected fun getApi(): T = createRetrofit().create(getApiClass())

    protected abstract fun getApiClass(): Class<T>

    protected abstract fun getBaseUrl(): String

    open fun createHeaders(): Headers {
        return Headers.of()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(createClient())
            .build()
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .headers(createHeaders())
                val request = requestBuilder.build()
                chain.proceed(request)
            }
        }.build()
    }

}