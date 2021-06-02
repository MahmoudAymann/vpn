package com.qm.cleanmodule.ui.fragment.login

import android.app.Application
import com.qm.cleanmodule.base.network.RetrofitBuilder
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.data.remote.ApiHelper
import com.qm.cleanmodule.util.Resources
import com.qm.cleanmodule.util.requestNewCallRefactor

class LoginViewModel(app: Application) : AndroidBaseViewModel(app) {

    val request = LoginRequest()
    private val apiHelper = ApiHelper(RetrofitBuilder.API_SERVICE)

    fun onLoginClick() {
        if (request.isValid()) {
            requestNewCallRefactor({ loginCall() }) {
                postResult(Resources.success(it, it.message))
            }
        } else {
            postResult(Resources.message(app.getString(R.string.all_data_required)))
        }
    }

    fun onBackClick(){
        setValue(Codes.BACK_BUTTON_PRESSED)
    }

    private suspend fun loginCall() = apiHelper.login(request)


}