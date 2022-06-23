package com.example.data.Models.Remote.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("dni") var dni : String,
    @SerializedName("password") var password : String
)