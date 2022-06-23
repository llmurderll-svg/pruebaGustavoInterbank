package com.example.testgustavointerbank.di

import com.example.testgustavointerbank.ui.Login.Login.LoginViewModel
import com.example.testgustavointerbank.ui.Menu.Details.DetailsViewModel
import com.example.testgustavointerbank.ui.Menu.Moves.MovesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(),get(),get()) }
    viewModel { DetailsViewModel(get(),get()) }
    viewModel { MovesViewModel(get()) }
}