package com.example.testgustavointerbank.ui.Login.Login

import android.R.attr
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.testgustavointerbank.R
import com.example.testgustavointerbank.databinding.FragmentLoginBinding
import com.example.testgustavointerbank.ui.base.BaseFragment
import com.example.testgustavointerbank.ui.base.LogoutWorker
import com.google.common.util.concurrent.ListenableFuture
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.ExecutionException


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val mViewModel by viewModel<LoginViewModel>()

    override fun getLayoutRes(): Int {
        return R.id.loginFragment
    }

    override fun initView() {
        if(isWorkManagerRunning()){
            goToHome()
        }
        dataBinding.apply {
            btnLoginButton.setOnClickListener { v ->
                mViewModel.getUser(inputDniLogin.text.toString(), inputPasswordLogin.text.toString())
            }
        }
    }

    override fun onListener() {
        super.onListener()
        mViewModel.userLogged.observe(viewLifecycleOwner){ loginUser ->
            loginUser?.let {
                setOneTimerWOrkRequest()
                goToHome()
            }
        }

        mViewModel.onLoading.observe(viewLifecycleOwner){ loading ->
           when(loading){
                true -> showProgress()
                false -> hideProgress()
           }
        }
        mViewModel.onErrorValidation.observe(viewLifecycleOwner){
            showToast(it.errorMessage)
        }
    }

    private fun goToHome() {
        findNavController().navigate(R.id.goto_main)
        requireActivity().finish()
    }

    private fun setOneTimerWOrkRequest() {
        val workManager = WorkManager.getInstance(requireContext())
        workManager.cancelUniqueWork("TIMECONTROL")
        val  uploadRequest = OneTimeWorkRequest.Builder(LogoutWorker::class.java).addTag("TIMECONTROL").build()
        workManager.enqueueUniqueWork(
            "TIMECONTROL",
            ExistingWorkPolicy.REPLACE,
            uploadRequest
        )
    }

    private fun isWorkManagerRunning() : Boolean{
        val instance = WorkManager.getInstance(requireContext())
        val statuses: ListenableFuture<List<WorkInfo>> = instance.getWorkInfosByTag("TIMECONTROL")
        return try {
            var running = false
            val workInfoList: List<WorkInfo> = statuses.get()
            for (workInfo in workInfoList) {
                val state = workInfo.state
                running = (state == WorkInfo.State.RUNNING) or  (state == WorkInfo.State.ENQUEUED)
            }
            running
        } catch (e: ExecutionException) {
            e.printStackTrace()
            false
        } catch (e: InterruptedException) {
            e.printStackTrace()
            false
        }
    }
}