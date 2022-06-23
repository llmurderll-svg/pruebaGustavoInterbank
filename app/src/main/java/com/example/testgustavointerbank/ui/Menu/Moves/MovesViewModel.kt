package com.example.testgustavointerbank.ui.Menu.Moves

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Entity.MoveEntity
import com.example.domain.UseCases.GetMovesUseCase
import com.example.testgustavointerbank.models.MoveModel
import com.example.testgustavointerbank.models.toModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MovesViewModel(private val getMovesUseCase: GetMovesUseCase) : ViewModel() {
    private val _moves = MutableLiveData<List<MoveModel>>()
    val moves : LiveData<List<MoveModel>> = _moves

    private val _onLoading = MutableLiveData<Boolean>()
    val onLoading : LiveData<Boolean> = _onLoading

    init{
        getMoves()
    }

    private fun getMoves() {
        _onLoading.postValue(true)
        viewModelScope.launch {
            getMovesUseCase().also { movesEntity ->
                delay(2000)
                _moves.value = movesEntity.map{ it.toModel()}
                _onLoading.postValue(false)
            }
        }
    }
}