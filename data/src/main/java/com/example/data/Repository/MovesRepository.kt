package com.example.data.Repository

import com.example.data.Models.Remote.response.MovesResponse
import com.example.data.Models.Remote.response.ProductsResponse
import com.example.data.Remote.ApiServiceClient

class MovesRepository(private val apiServiceClient : ApiServiceClient) {
    suspend fun getMoves() : List<MovesResponse>{
        return apiServiceClient.getMoves()
    }
}