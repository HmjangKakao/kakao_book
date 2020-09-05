package com.hmjang.kakaobook.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hmjang.kakaobook.data.view.BookItemModel

const val VIEW_TYPE_NORMAL = 1
const val VIEW_TYPE_LOADING = 2

class BookListAdapter : ListAdapter<BookItemModel, RecyclerView.ViewHolder>(DIFF_UTIL) {
    private var isLoaderVisible = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEW_TYPE_NORMAL -> BookListViewHolder(parent)
            VIEW_TYPE_LOADING -> FooterLoadingViewHolder(parent)
            else -> BookListViewHolder(parent)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_NORMAL -> (holder as BookListViewHolder).onBindViewHolder(getItem(position))
            else -> {
                //do nothing
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoaderVisible) {
            if (position == currentList.size - 1) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    private fun add(model: BookItemModel) {
        currentList.add(model)
        submitList(currentList)
        notifyItemInserted(currentList.size - 1)
    }

    fun addLoading() {
        if (isLoaderVisible) {
            isLoaderVisible = true
            add(dummyItem())
        }
    }

    fun removeLoading() {
        if (isLoaderVisible) {
            isLoaderVisible = false
            val position: Int = currentList.size - 1
            currentList.removeAt(position)
            submitList(currentList)
            notifyItemRemoved(position)
        }
    }

    private fun dummyItem(): BookItemModel {
        return BookItemModel()
    }
}

val DIFF_UTIL = object : DiffUtil.ItemCallback<BookItemModel>() {
    override fun areItemsTheSame(
        oldItem: BookItemModel,
        newItem: BookItemModel
    ): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: BookItemModel,
        newItem: BookItemModel
    ): Boolean = areItemsTheSame(oldItem, newItem)
}