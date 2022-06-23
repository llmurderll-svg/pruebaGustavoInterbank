package com.example.domain.Entity

data class LoginEntity(
    var token : String? = null,
    var expire : String ?= null,
    var products : List<ProductEntity> = emptyList()
)