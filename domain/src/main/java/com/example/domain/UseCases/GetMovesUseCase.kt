package com.example.domain.UseCases

import com.example.data.Repository.MovesRepository
import com.example.domain.Entity.MoveEntity
import com.example.domain.mappers.toDomain

class GetMovesUseCase(private val repository : MovesRepository){

    suspend operator fun invoke() : List<MoveEntity>{
        val response = repository.getMoves()
        return response.map{ it.toDomain() }
    }
}