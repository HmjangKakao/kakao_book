package com.hmjang.kakaobook.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("load_image")
fun ImageView.load(any: Any) {
    Glide.with(this).load(any).into(this)
}