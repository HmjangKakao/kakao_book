package com.hmjang.kakaobook.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity<T : ViewDataBinding>(@LayoutRes layoutResId: Int) :
    AppCompatActivity() {

    protected val binding: T by lazy {
        DataBindingUtil.setContentView(this, layoutResId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding()
    }

    private fun dataBinding() {
        val owner = this
        binding.apply {
            lifecycleOwner = owner
        }
    }

}