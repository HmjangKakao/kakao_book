package com.hmjang.kakaobook.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hmjang.kakaobook.data.remote.BookModel

class BookListAdapter : ListAdapter<BookModel, BookListViewHolder>(DIFF_UTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder = BookListViewHolder(parent)

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int): Unit = holder.onBindViewHolder(getItem(position))
}

val DIFF_UTIL = object : DiffUtil.ItemCallback<BookModel>() {
    override fun areItemsTheSame(
        oldItem: BookModel,
        newItem: BookModel
    ): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: BookModel,
        newItem: BookModel
    ): Boolean = areItemsTheSame(oldItem, newItem)
}