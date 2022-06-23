package com.example.data.Models.Remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") val token : String,
    @SerializedName("expire") val expire : String,
    @SerializedName("products") val products : List<ProductsResponse>,
)