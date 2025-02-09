package com.straccion.ecommerce.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.screens.auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")


    var registerResponse by mutableStateOf<Response<AuthResponse>?>(null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSessionUseCase(authResponse)
    }

    fun register() = viewModelScope.launch {
        if (isValidateForm()){
            registerResponse = Response.Loading
            val result = authUseCase.register(user = state.toUser())
            registerResponse = result
        }
    }



    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String) {
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String) {
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String) {
        state = state.copy(confirmPassword = input)
    }

    fun isValidateForm():Boolean {

        if (state.name == "") {
            errorMessage = "Ingresa el nombre"
            return false
        }
        else if (state.lastname == "") {
            errorMessage = "Ingresa el apellido"
            return false
        }
        else if (state.email == "") {
            errorMessage = "Ingresa el email"
            return false
        }
        else if (state.phone == "") {
            errorMessage = "Ingresa el telefono"
            return false
        }
        else if (state.password == "") {
            errorMessage = "Ingresa el password"
            return false
        }
        else if (state.confirmPassword == "") {
            errorMessage = "Ingresa el password de confirmacion"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.password != state.confirmPassword) {
            errorMessage = "Las contraseñas no coinciden"
            return false
        }
        return true
    }

}