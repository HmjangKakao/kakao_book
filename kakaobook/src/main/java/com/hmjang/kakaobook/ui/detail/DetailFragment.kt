package com.hmjang.kakaobook.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hmjang.kakaobook.R
import com.hmjang.kakaobook.databinding.DetailFragmentBinding
import com.hmjang.kakaobook.extension.getViewModelFactory
import com.hmjang.kakaobook.extension.toast
import com.hmjang.kakaobook.ui.base.BaseBindingFragment

class DetailFragment : BaseBindingFragment<DetailFragmentBinding>(R.layout.detail_fragment) {
    override val viewModel: DetailFragmentViewModel by viewModels { getViewModelFactory() }

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeButton()
        observeWarning()
    }

    private fun observeButton() {
        binding.onClickDetail = View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.tag.toString()))
            startActivity(intent)
        }
    }

    private fun observeWarning() {
        viewModel.onWarningMsg.observe(viewLifecycleOwner, {
            context?.toast(it)
        })
    }

}