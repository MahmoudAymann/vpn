package com.qm.cleanmodule.ui.fragment.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.qm.cleanmodule.base.view.BaseFragment
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.databinding.FragmentLoginBinding
import com.qm.cleanmodule.util.DialogsExtensions.showErrorDialog
import com.qm.cleanmodule.util.DialogsExtensions.showSuccessfulDialog
import com.qm.cleanmodule.util.Status
import com.qm.cleanmodule.util.navigateSafe
import com.qm.cleanmodule.util.observe
import com.qm.cleanmodule.util.showDialog

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override fun pageTitle(): String = ""
    override val mViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.apply {
            observe(mutableLiveData) {
                when (it) {
                    Codes.BACK_BUTTON_PRESSED -> activity?.onBackPressed()
                }
            }
            observe(resultLiveData) {
                when (it?.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                        activity?.showSuccessfulDialog("done"){

                        }
                    }
                    Status.MESSAGE -> {
                        activity?.showErrorDialog(it.message)
                        showProgress(false)
                    }
                    Status.LOADING -> showProgress()
                }
            }
        }
    }
}