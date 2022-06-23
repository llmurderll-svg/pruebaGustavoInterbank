package com.example.di

import com.example.data.Core.RetrofitBuilder
import com.example.data.Remote.ApiServiceClient
import com.example.data.Repository.MovesRepository
import com.example.data.Repository.ProductsRepository
import com.example.data.Repository.UserRepository
import org.koin.dsl.module

val coreModule = module {
    single{
        RetrofitBuilder().createRetrofitBuilder()
    }
}

val remoteModule = module {
    factory { ApiServiceClient(get()) }
}

val repositoryModule = module {
    single { ProductsRepository(get()) }
    single { UserRepository(get()) }
    single { MovesRepository(get()) }
}