package com.qm.cleanmodule.ui.activity


import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.view.BaseActivity
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.databinding.ActivityMainBinding
import com.qm.cleanmodule.util.*
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavController()
        mViewModel.apply {
            isLoading = baseShowProgress
            observe(mutableLiveData) {
                when (it) {
                    Codes.BACK_BUTTON_PRESSED -> onBackPressed()
                }
            }
        }
    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
    }


    fun changeTitle(title: String?) {
        title?.let {
            mViewModel.obsTitle.set(title)
        }
    }


}
