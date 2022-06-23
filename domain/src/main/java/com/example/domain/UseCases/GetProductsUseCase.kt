package com.example.domain.UseCases

import com.example.data.Repository.ProductsRepository
import com.example.domain.Entity.ProductEntity
import com.example.domain.mappers.toDomain

class GetProductsUseCase(private val repository: ProductsRepository) {

    suspend operator fun invoke() : List<ProductEntity>{
        val response = repository.getProducts()
        return response.map { it.toDomain() }
    }

}