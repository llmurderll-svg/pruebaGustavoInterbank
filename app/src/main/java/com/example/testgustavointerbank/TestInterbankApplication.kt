package com.example.testgustavointerbank

import android.app.Application
import com.example.di.coreModule
import com.example.di.remoteModule
import com.example.di.repositoryModule
import com.example.di.useCasesModule
import com.example.testgustavointerbank.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestInterbankApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestInterbankApplication)
            modules(
                listOf(
                    useCasesModule,
                    coreModule,
                    remoteModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}