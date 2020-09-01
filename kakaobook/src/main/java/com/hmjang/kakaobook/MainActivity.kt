package com.hmjang.kakaobook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hmjang.kakaobook.ui.main.MainListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainListFragment.newInstance())
                    .commitNow()
        }
    }
}
