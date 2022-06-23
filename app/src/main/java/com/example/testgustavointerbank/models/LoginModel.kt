package com.example.testgustavointerbank.models


data class LoginModel(
    var token : String? = null,
    var expire : String ?= null,
    var products : List<ProductModel> = emptyList()
)