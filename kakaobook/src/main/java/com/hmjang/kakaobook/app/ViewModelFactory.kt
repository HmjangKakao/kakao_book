package com.hmjang.kakaobook.app

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.hmjang.kakaobook.ui.detail.DetailFragment
import com.hmjang.kakaobook.ui.detail.DetailFragmentViewModel
import com.hmjang.kakaobook.ui.main.MainListFragment
import com.hmjang.kakaobook.ui.main.MainListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val owner: SavedStateRegistryOwner,
    private val defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    // todo repository 추가해서 viewModel 데이터 테스트
    
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(MainListViewModel::class.java) -> MainListViewModel()
            isAssignableFrom(DetailFragmentViewModel::class.java) -> DetailFragmentViewModel(
                defaultArgs
            )
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}