package com.example.data.Models.Remote.response

import com.google.gson.annotations.SerializedName

data class MovesResponse(
    @SerializedName("typeMove") val typeMove : String,
    @SerializedName("dateMove") val dateMove : String,
    @SerializedName("mountMove") val mountMove : String
)