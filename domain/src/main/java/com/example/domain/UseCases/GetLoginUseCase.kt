package com.example.domain.UseCases

import com.example.data.Models.Remote.request.LoginRequest
import com.example.data.Repository.UserRepository
import com.example.domain.Entity.LoginEntity
import com.example.domain.mappers.toDomain

class GetLoginUseCase(private val repository: UserRepository){

    suspend operator fun invoke(dni : String, password : String) : LoginEntity{
        val response = repository.login(
            LoginRequest(dni, password)
        )
        return LoginEntity(
            token = response.token,
            expire = response.expire,
            products = response.products.map { it.toDomain() }
        )
    }

}

