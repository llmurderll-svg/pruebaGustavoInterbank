package com.example.data.Repository

import com.example.data.Models.Remote.request.LoginRequest
import com.example.data.Models.Remote.response.LoginResponse
import com.example.data.Remote.ApiServiceClient

class UserRepository(private val apiServiceClient : ApiServiceClient) {

    suspend fun login(user : LoginRequest) : LoginResponse {
        return  apiServiceClient.loginUser(user)
    }

}