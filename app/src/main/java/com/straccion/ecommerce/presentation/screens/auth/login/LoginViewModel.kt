package com.straccion.ecommerce.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.ui.theme.Constants.ERROR_VALIDATE_EMAIL
import com.straccion.ecommerce.presentation.ui.theme.Constants.ERROR_VALIDATE_PASSWORD
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    //Login Response
    var loginResponse by mutableStateOf<Response<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionDataUseCase().collect(){data ->
            if (data.token?.isNotEmpty() == true){
                loginResponse = Response.Success(data)
            }else{
                Log.d("LoginViewModel", "Data: null")
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSessionUseCase(authResponse)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginResponse = Response.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResponse = result
        }
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = ERROR_VALIDATE_EMAIL
            return false
        } else if (state.password.length < 6) {
            errorMessage = ERROR_VALIDATE_PASSWORD
            return false
        }
        return true
    }
}