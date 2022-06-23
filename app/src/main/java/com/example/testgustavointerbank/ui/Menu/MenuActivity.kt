package com.example.testgustavointerbank.ui.Menu

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testgustavointerbank.R
import com.example.testgustavointerbank.ui.base.BaseActivity
import com.example.testgustavointerbank.databinding.ActivityMenuBinding

//@AndroidEntryPoint
class MenuActivity : BaseActivity<ActivityMenuBinding>() {

    lateinit var navController: NavController

    override fun getLayoutRes(): Int {
        return R.layout.activity_menu
    }

    override fun initView() {
        navController = findNavController(R.id.navigation_menu)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_detail,
                R.id.navigation_notification
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        dataBinding.bottomNavigationView.setupWithNavController(navController)
    }
}