package com.example.di

import com.example.domain.UseCases.*
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetProductsUseCase(get()) }
    factory { GetUploadProductsUseCase(get()) }
    factory { GetLoginUseCase(get()) }
    factory { GetMovesUseCase(get()) }
    factory { ValidateDniUseCase() }
    factory { ValidatePasswordUseCase() }
}