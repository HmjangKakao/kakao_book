package com.hmjang.kakaobook.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.hmjang.kakaobook.R
import com.hmjang.kakaobook.databinding.MainListFragmentBinding
import com.hmjang.kakaobook.ui.base.BaseBindingFragment
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_list_fragment.*
import java.util.concurrent.TimeUnit

class MainListFragment : BaseBindingFragment<MainListFragmentBinding>(R.layout.main_list_fragment) {

    companion object {
        fun newInstance() = MainListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override val viewModel: ViewModel
        get() = MainListViewModel()

}
