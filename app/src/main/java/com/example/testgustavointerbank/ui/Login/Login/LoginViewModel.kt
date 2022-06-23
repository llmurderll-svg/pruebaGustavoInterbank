package com.example.testgustavointerbank.ui.Login.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Entity.LoginEntity
import com.example.domain.UseCases.GetLoginUseCase
import com.example.domain.UseCases.ValidateDniUseCase
import com.example.domain.UseCases.ValidatePasswordUseCase
import com.example.domain.UseCases.Validations.ValidationResult
import com.example.testgustavointerbank.models.LoginModel
import com.example.testgustavointerbank.models.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getLoginUseCase: GetLoginUseCase,
    private val validateDniUseCase : ValidateDniUseCase,
    private val validatePasswordUseCase : ValidatePasswordUseCase
    ): ViewModel() {

    private val _userLogged = MutableLiveData<LoginModel>()
    val userLogged : LiveData<LoginModel> = _userLogged

    private val _onLoading = MutableLiveData<Boolean>()
    val onLoading : LiveData<Boolean> = _onLoading

    private val _onErrorValidation = MutableLiveData<ValidationResult>()
    val onErrorValidation : LiveData<ValidationResult> = _onErrorValidation

    fun getUser(dni : String?, password : String?){
        val dniResult = validateDniUseCase(dni ?: "")
        val passwordResult = validatePasswordUseCase( password ?: "")
        if(!dniResult.successful){
            _onErrorValidation.postValue(dniResult)
            return
        }
        if(!passwordResult.successful){
            _onErrorValidation.postValue(passwordResult)
            return
        }
        getLogin(dni, password)
    }

    fun getLogin(dni : String?, password : String?){
        _onLoading.postValue(true)
        viewModelScope.launch {
            getLoginUseCase(dni ?: "",password ?: "").also {
                viewModelScope.launch(Dispatchers.Main) {
                    delay(1000)
                    _userLogged.value = it.toModel()
                    _onLoading.postValue(false)
                }
            }
        }
    }

}