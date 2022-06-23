package com.example.data.Models.Remote.response

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("typeAccount") val typeAccount : String,
    @SerializedName("mountAccount") val mountAccount : String,
    @SerializedName("numberAccount") val numberAccount : String,
)