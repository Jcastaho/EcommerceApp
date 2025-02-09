package com.straccion.ecommerce.presentation.screens.roles

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RolesViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var authResponse by mutableStateOf(AuthResponse())
        private set

    init {
        getSessionData()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionDataUseCase().collect(){data ->
            if (data.token?.isNotEmpty() == true){
                authResponse = data
            }else{
                Log.d("LoginViewModel", "Data: null")
            }
        }
    }
}