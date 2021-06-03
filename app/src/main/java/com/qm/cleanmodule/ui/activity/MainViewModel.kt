package com.qm.cleanmodule.ui.activity

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.constants.Codes

class MainViewModel(app: Application) : AndroidBaseViewModel(app) {

    val obsTitle = ObservableField<String>()



}