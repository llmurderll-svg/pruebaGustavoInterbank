package com.example.data.Remote

import com.example.data.Models.Remote.request.LoginRequest
import com.example.data.Models.Remote.response.ProductsResponse
import com.example.data.Models.Remote.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @POST("api/loginUser")
    suspend fun login(@Body loginRequest: LoginRequest) : Response<LoginResponse>

    @GET("api/getProducts")
    suspend fun getProducts() :Response<List<ProductsResponse>>

    @GET("api/getUploadProducts")
    suspend fun getUploadProducts() :Response<List<ProductsResponse>>
}