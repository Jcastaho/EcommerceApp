package com.straccion.ecommerce.presentation.screens.client.address.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.domains.usecase.address.AddressUseCase
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import com.straccion.ecommerce.domains.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressListViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var addressResponse by mutableStateOf<Response<List<Address>>?>(null)
        private set


    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionDataUseCase().first().user
        getAddress(user?.id ?: "")
    }

    fun getAddress(idUser: String) = viewModelScope.launch{
        addressResponse = Response.Loading
        addressUseCase.findByUserAddressUseCase(idUser).collect(){
            addressResponse =it
        }
    }

}