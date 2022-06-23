package com.example.testgustavointerbank.ui.base

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dmax.dialog.SpotsDialog


abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity() {

    lateinit var dataBinding: D

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun initView()

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        dataBinding.lifecycleOwner = this
        initView()
        onResponse()
        onListener()
    }

    open fun onListener() {
    }


    open fun onResponse() {
    }

    fun showProgress(message: String? = "Cargando") {
        hideProgress()

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog.setMessage(message)
        dialog.show()
    }

     fun hideProgress() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

    fun goToActivity(destinationClass: Class<*>, bundle: Bundle? = null, finish: Boolean = false) {
        startActivity(Intent(this, destinationClass).apply {
            if (bundle != null)
                putExtras(bundle)
        })

        if (finish) finish()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}