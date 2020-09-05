package com.hmjang.kakaobook.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.hmjang.kakaobook.R
import com.hmjang.kakaobook.databinding.MainListFragmentBinding
import com.hmjang.kakaobook.extension.toast
import com.hmjang.kakaobook.ui.base.BaseBindingFragment
import com.hmjang.kakaobook.ui.main.adapter.BookListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_list_fragment.*
import java.util.concurrent.TimeUnit

const val UP = -1
const val BOTTOM = 1

class MainListFragment : BaseBindingFragment<MainListFragmentBinding>(R.layout.main_list_fragment) {

    override val viewModel: MainListViewModel get() = ViewModelProvider(this).get(MainListViewModel::class.java)

    companion object {
        fun newInstance() = MainListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViewAdapter()
        setRecyclerViewScrollListener()
        observeEditText()
        observeBookList()
        observeLoading()
        observeWarning()
    }

    private fun setRecyclerViewAdapter() {
        rv_search_result.adapter = BookListAdapter()
    }

    private fun setRecyclerViewScrollListener() {
        rv_search_result.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when {
                    recyclerView.canScrollVertically(UP).not() -> {
                        //todo refresh entire content?
                    }
                    recyclerView.canScrollVertically(BOTTOM).not() -> {
                        if (viewModel.requestMoreBooks()) {
                            (rv_search_result.adapter as? BookListAdapter)?.addLoading()
                        }
                    }
                    else -> {

                    }
                }
            }
        })
    }

    private fun observeEditText() {
        Observable.fromPublisher(LiveDataReactiveStreams.toPublisher(viewLifecycleOwner, viewModel.keyword))
            .debounce(500, TimeUnit.MILLISECONDS)
            .filter { it.isNotEmpty() && it.isNotBlank() }
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                viewModel.searchBook(it)
            }
    }

    private fun observeBookList() {
        viewModel.items.observe(viewLifecycleOwner, {
            (rv_search_result.adapter as? BookListAdapter)?.apply {
                removeLoading()
                submitList(it)
            }
        })
    }

    private fun observeLoading() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            pb_searching.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    private fun observeWarning() {
        viewModel.onWarningMsg.observe(viewLifecycleOwner, {
            context?.toast(it)
        })
    }

}
