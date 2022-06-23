package com.example.domain.mappers

import com.example.data.Models.Remote.response.LoginResponse
import com.example.data.Models.Remote.response.MovesResponse
import com.example.data.Models.Remote.response.ProductsResponse
import com.example.domain.Entity.LoginEntity
import com.example.domain.Entity.MoveEntity
import com.example.domain.Entity.ProductEntity

fun ProductsResponse.toDomain() = ProductEntity(
    typeAccount = typeAccount,
    mountAccount = mountAccount,
    numberAccount = numberAccount
)

fun MovesResponse.toDomain() = MoveEntity(
    typeMove = typeMove,
    dateMove = dateMove,
    mountMove = mountMove
)

fun LoginResponse.toDomain() = LoginEntity(
    token = token,
    expire = expire,
    products = products.map { it.toDomain() }
)
