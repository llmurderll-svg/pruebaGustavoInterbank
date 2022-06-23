package com.example.data.Core

import android.content.Context
import com.example.data.Remote.ApiClient
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder() {

    //Crea un constructor de retrofit-
    fun createRetrofitBuilder() : ApiClient{
        val interceptor = interceptor()
        val okHttpClientBuilder = OkHttpClient
            .Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
        //Set URL
        return Retrofit
            .Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
            .create(ApiClient::class.java)
    }

    //Crea el interceptor
    private fun interceptor() : HttpLoggingInterceptor{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return  httpLoggingInterceptor
    }
}