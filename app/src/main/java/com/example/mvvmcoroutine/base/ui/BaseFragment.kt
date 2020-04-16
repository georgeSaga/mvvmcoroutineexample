package com.example.mvvmcoroutine.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmcoroutine.base.event.ViewEvent
import com.example.mvvmcoroutine.base.extensions.observeNotNull
import com.example.mvvmcoroutine.base.vm.BaseViewModel
import com.example.mvvmcoroutine.base.vm.BaseViewModelFactory

abstract class BaseFragment<T : BaseViewModel>(

    private val viewModelClass: Class<T>

) : Fragment(), BackPressHandler {

    protected abstract val layoutId: Int

    protected abstract val dataBindingVariable: Int

    protected val viewModel: T
        get() = _viewModel

    private lateinit var _viewModel: T

    private lateinit var binding: ViewDataBinding

    private val _viewModelFactory: BaseViewModelFactory<T> by lazy { getViewModelFactory() }

    abstract fun getViewModelFactory(): BaseViewModelFactory<T>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // no super
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.let(this::restoreState)
        initViews(savedInstanceState)
    }

    @CallSuper
    protected open fun restoreState(bundle: Bundle) = Unit

    protected open fun initViews(savedInstanceState: Bundle?) {

        initViewModel()
        subscribeViewModelEvents()
        lifecycle.addObserver(viewModel)
    }

    private fun initViewModel() {

        _viewModel = ViewModelProviders.of(this, _viewModelFactory).get(viewModelClass)
        binding.setVariable(dataBindingVariable, viewModel)
        binding.lifecycleOwner = this
    }

    private fun subscribeViewModelEvents() {
        observeNotNull(viewModel.viewEvents, this::onNewViewEvent)
    }

    protected open fun onNewViewEvent(event: ViewEvent) = event.execute(this)

    final override fun onSaveInstanceState(outState: Bundle) {

        val bundle = saveState(outState)
        super.onSaveInstanceState(bundle)
    }

    @CallSuper
    protected open fun saveState(bundle: Bundle): Bundle = bundle

    override fun handleBackPress() = false

}