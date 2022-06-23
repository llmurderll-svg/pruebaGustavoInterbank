package com.example.domain.UseCases.Validations

data class ValidationResult(
    val successful : Boolean,
    val errorMessage : String
)