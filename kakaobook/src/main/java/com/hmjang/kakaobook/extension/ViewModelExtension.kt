package com.hmjang.kakaobook.extension

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hmjang.kakaobook.app.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(
        owner = this,
        defaultArgs = arguments
    )
}

fun AppCompatActivity.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(
        owner = this,
        intent = intent
    )
}