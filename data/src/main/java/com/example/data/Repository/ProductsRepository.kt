package com.example.data.Repository

import com.example.data.Models.Remote.response.ProductsResponse
import com.example.data.Remote.ApiServiceClient

class ProductsRepository(private val apiServiceClient : ApiServiceClient) {

    suspend fun getProducts() : List<ProductsResponse>{
        return apiServiceClient.getProducts()
    }

    suspend fun getUploadProducts() : List<ProductsResponse>{
        return apiServiceClient.getUploadProducts()
    }

}