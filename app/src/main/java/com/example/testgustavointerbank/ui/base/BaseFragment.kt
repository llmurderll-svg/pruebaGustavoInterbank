package com.example.testgustavointerbank.ui.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dmax.dialog.SpotsDialog
import java.lang.reflect.ParameterizedType

abstract class BaseFragment <D : ViewDataBinding> : Fragment(){

    private var _dataBinding: D? = null
    val dataBinding get() = _dataBinding!!

    private lateinit var dialog: AlertDialog

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun initView()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val type = javaClass.genericSuperclass
        val clazz = (type as ParameterizedType).actualTypeArguments[0] as Class<D>
        val method = clazz.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        _dataBinding = method.invoke(null, layoutInflater, container, false) as D
        dialog = SpotsDialog.Builder().setCancelable(false).setContext(requireContext()).build()
        initView()
        onResponse()
        onListener()
        return _dataBinding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _dataBinding = null
    }

    open fun onListener() {
    }


    open fun onResponse() {

    }

    fun showProgress(message: String? = "Cargando") {
        hideProgress()

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(requireContext()).build()
        dialog.setMessage(message)
        dialog.show()
    }

    fun hideProgress() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}