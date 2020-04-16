package com.example.mvvmcoroutine.main.ui

import com.example.mvvmcoroutine.R
import com.example.mvvmcoroutine.BR
import com.example.mvvmcoroutine.base.extensions.appProvider
import com.example.mvvmcoroutine.base.ui.BaseFragment
import com.example.mvvmcoroutine.base.vm.BaseViewModelFactory
import com.example.mvvmcoroutine.main.ui.vm.MainViewModel
import com.example.mvvmcoroutine.main.ui.vm.MainViewModelFactory

class MainFragment : BaseFragment<MainViewModel>(MainViewModel::class.java) {
    override val layoutId = R.layout.fragment_main
    override val dataBindingVariable: Int = BR.viewModel

    override fun getViewModelFactory(): BaseViewModelFactory<MainViewModel> =
        MainViewModelFactory(activity?.appProvider!!)
}