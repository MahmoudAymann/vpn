package com.qm.cleanmodule.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.qm.cleanmodule.BR
import com.qm.cleanmodule.util.bindView

/**
 * Created by MahmoudAyman on 7/17/2020.
 **/

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    val baseShowProgress = ObservableBoolean()
    protected abstract val mViewModel: VM
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView()
        binding.setVariable(BR.viewModel, mViewModel)
    }



}
