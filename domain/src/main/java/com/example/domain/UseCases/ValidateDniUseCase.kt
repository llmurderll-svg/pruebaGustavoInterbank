package com.example.domain.UseCases

import com.example.domain.UseCases.Validations.ValidationResult

class ValidateDniUseCase {
    operator fun invoke(dni : String) : ValidationResult{
        if(dni.isBlank()) return ValidationResult(false,"Falta el DNI")
        if(dni.length != 8) return ValidationResult(false,"Error en en DNI")
        return ValidationResult(true, "")
    }
}