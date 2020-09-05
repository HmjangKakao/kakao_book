package com.hmjang.kakaobook.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hmjang.kakaobook.R
import com.hmjang.kakaobook.data.view.BookItemModel
import com.hmjang.kakaobook.databinding.ItemBookBinding

class BookListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
) {
    private val binding = DataBindingUtil.bind<ItemBookBinding>(itemView)!!

    fun onBindViewHolder(item: BookItemModel) {
        binding.item = item
        itemView.setOnClickListener {
            it.findNavController().navigate(
                R.id.detailFragment,
                bundleOf("data" to item)
            )
        }
    }
}