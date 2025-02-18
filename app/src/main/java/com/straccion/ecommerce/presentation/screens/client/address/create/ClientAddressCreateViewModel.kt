package com.straccion.ecommerce.presentation.screens.client.address.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.domains.usecase.address.AddressUseCase
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.screens.client.address.create.mapper.toAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressCreateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val addressUseCase: AddressUseCase
) : ViewModel() {

    var state by mutableStateOf(ClientAddressCreateState())
        private set

    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionDataUseCase().first().user
        state = state.copy(idUser = user?.id ?: "")
    }

    var addressResponse by mutableStateOf<Response<Address>?>(null)

    fun createAddress() = viewModelScope.launch {
        addressResponse = Response.Loading
        val result = addressUseCase.createAddressUseCase(state.toAddress())
        addressResponse = result
    }

    fun onAddressInput(address: String) {
        state = state.copy(address = address)
    }

    fun onNeighborhoodInput(neighborhood: String) {
        state = state.copy(neighborhood = neighborhood)
    }

    fun clearForm(){
        state = state.copy(
            address = "",
            neighborhood = "",
            idUser = ""
        )
        addressResponse = null
    }
}