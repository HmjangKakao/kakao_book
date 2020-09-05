package com.hmjang.kakaobook

object KeyHolder {

    init {
        System.loadLibrary("apiKeystore")
    }

    external fun getApiKey(): String

}