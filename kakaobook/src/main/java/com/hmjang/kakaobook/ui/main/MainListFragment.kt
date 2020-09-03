package com.hmjang.kakaobook.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModelProvider
import com.hmjang.kakaobook.R
import com.hmjang.kakaobook.databinding.MainListFragmentBinding
import com.hmjang.kakaobook.ui.base.BaseBindingFragment
import com.hmjang.kakaobook.ui.main.adapter.BookListAdapter
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_list_fragment.*
import java.util.concurrent.TimeUnit


class MainListFragment : BaseBindingFragment<MainListFragmentBinding>(R.layout.main_list_fragment) {

    override val viewModel: MainListViewModel get() = ViewModelProvider(this).get(MainListViewModel::class.java)

    companion object {
        fun newInstance() = MainListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        Observable.fromPublisher(LiveDataReactiveStreams.toPublisher(viewLifecycleOwner, viewModel.queryKeyword))
            .debounce(750, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .subscribe {
                searchBook(it)
            }
    }

    private fun setAdapter() {
        rv_search_result.adapter = BookListAdapter()
    }

    private fun searchBook(queryKeyword: String) {
        viewModel.searchBook(queryKeyword)
    }

}
