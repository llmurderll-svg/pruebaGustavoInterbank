package com.example.testgustavointerbank.ui.base

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.testgustavointerbank.ui.Login.LoginActivity
import kotlinx.coroutines.delay
import java.lang.Exception

class LogoutWorker(context: Context, parameters : WorkerParameters) : CoroutineWorker(context, parameters) {
    val context = applicationContext
    override suspend fun doWork(): Result {
        for (i in 1..40){
            Log.d("TIMERCOUNTDOWN", i.toString())
            delay(1000)
        }
        Log.d("TIMERCOUNTDOWN", "finished")
        val  intent= Intent(context, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        return Result.success()
    }

}