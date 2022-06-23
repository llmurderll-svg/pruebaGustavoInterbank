package com.example.data.Remote

import com.example.data.Models.Remote.request.LoginRequest
import com.example.data.Models.Remote.response.ProductsResponse
import com.example.data.Models.Remote.response.LoginResponse
import com.example.data.Models.Remote.response.MovesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiServiceClient(private val api : ApiClient){
    //Implementar servicio mockeado
    suspend fun loginUser(request: LoginRequest) : LoginResponse{
        return withContext(Dispatchers.IO){
            //api.login()
            LoginResponse(
                token = "djasdjiasd65165asdsad651s51s5d15sas",
                expire = "4000",
                products = listOf(
                    ProductsResponse("Cuenta Soles", "S/. 1,500.00","99999999999999"),
                    ProductsResponse("Cuenta Soles", "S/. 1,000.80","11111111111111"),
                    ProductsResponse("Cuenta Dolares", "US$ 1,800.20","88888888888888")

                )
            )
        }
    }

    suspend fun getProducts() : List<ProductsResponse>{
        return withContext(Dispatchers.IO){
            //api.getProducts()
            listOf(
                ProductsResponse("Cuenta Soles", "S/. 1,500.00","99999999999999"),
                ProductsResponse("Cuenta Soles", "S/. 1,000.80","11111111111111"),
                ProductsResponse("Cuenta Dolares", "US$ 1,800.20","88888888888888")
            )
        }
    }

    suspend fun getUploadProducts() : List<ProductsResponse>{
        return withContext(Dispatchers.IO){
            //api.getUploadProducts()
            listOf(
                ProductsResponse("Cuenta Soles", "S/. 900.00","5516510651561"),
                ProductsResponse("Cuenta Dolares", "US$ 1,200.80","654616516"),
                ProductsResponse("Cuenta Dolares", "US$ 1,800.20","9616165165161869")
            )
        }
    }

    suspend fun getMoves() : List<MovesResponse>{
        return withContext(Dispatchers.IO){
            //api.getMoves()
            listOf(
                MovesResponse("Transferencia","25 Nov 2021", "S/. +6.10"),
                MovesResponse("Plin","25 Nov 2021", "S/. -10.00")
            )
        }
    }
}