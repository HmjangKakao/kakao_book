package com.hmjang.kakaobook

import android.util.Base64

object KeyHolder {

    init {
        System.loadLibrary("apiKeystore")
    }

    external fun getApiKey(): String

    fun getOriginalApiKey(): String {
        return String(Base64.decode(getApiKey(), Base64.DEFAULT))
    }

}