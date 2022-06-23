package com.example.domain.UseCases

import com.example.domain.UseCases.Validations.ValidationResult

class ValidatePasswordUseCase {
    operator fun invoke(password : String) : ValidationResult{
        if(password.isEmpty()) return ValidationResult(false, "Falta el Passwprd")
        if(password.length < 6) return ValidationResult(false, "Error Password")
        return ValidationResult(true, "")
    }
}