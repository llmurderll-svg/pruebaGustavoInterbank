package com.example.domain.UseCases

import com.example.data.Repository.ProductsRepository
import com.example.domain.Entity.ProductEntity
import com.example.domain.mappers.toDomain

class GetUploadProductsUseCase(private val repository: ProductsRepository) {

    suspend operator fun invoke() : List<ProductEntity> {
        val response = repository.getUploadProducts()
        return response.map { it.toDomain() }
    }
}