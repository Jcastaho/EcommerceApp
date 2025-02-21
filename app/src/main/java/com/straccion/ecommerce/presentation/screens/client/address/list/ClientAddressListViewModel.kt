package com.straccion.ecommerce.presentation.screens.client.address.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.domains.model.User
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

    var selectedAddress by mutableStateOf("")
        private set
    var user: User? = null

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionDataUseCase().first().user
        getAddress(user?.id ?: "")
        if (user?.address != null){
            selectedAddress = user?.address?.id ?: ""
        }
    }

    fun getAddress(idUser: String) = viewModelScope.launch{
        addressResponse = Response.Loading
        addressUseCase.findByUserAddressUseCase(idUser).collect(){
            addressResponse =it
        }
    }

    fun onSelectedAddressInput(address: Address) = viewModelScope.launch {
        selectedAddress = address.id ?: ""
        user?.address = address
        if (user != null){
            authUseCase.updateSessionUseCase(user!!)
        }

    }

}