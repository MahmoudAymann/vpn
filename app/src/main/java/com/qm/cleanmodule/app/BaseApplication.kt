package com.qm.cleanmodule.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.qm.cleanmodule.app.AppDataBindingComponent

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(AppDataBindingComponent())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}