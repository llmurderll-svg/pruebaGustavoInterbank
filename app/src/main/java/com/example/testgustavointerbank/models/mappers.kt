package com.example.testgustavointerbank.models

import com.example.domain.Entity.LoginEntity
import com.example.domain.Entity.MoveEntity
import com.example.domain.Entity.ProductEntity

fun ProductEntity.toModel() = ProductModel(
    typeAccount = typeAccount,
    mountAccount = mountAccount,
    numberAccount = numberAccount
)

fun MoveEntity.toModel() = MoveModel(
    typeMove = typeMove,
    dateMove = dateMove,
    mountMove = mountMove
)

fun LoginEntity.toModel() = LoginModel(
    token = token,
    expire = expire,
    products = products.map { it.toModel() }
)
