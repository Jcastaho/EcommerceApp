package com.straccion.ecommerce.presentation.screens.client.products.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.usecase.products.ProductsUseCase
import com.straccion.ecommerce.domains.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ClientProductListViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
): ViewModel() {
    var produtcsResponse by mutableStateOf<Response<List<Product>>?>(null)
        private set

    init {
        getProduts()
    }

    fun getProduts() = viewModelScope.launch {
        produtcsResponse = Response.Loading
        productsUseCase.findAllUseCase().collect(){
            Log.d("ClientProductListViewModel", "Data: $it")
            produtcsResponse = it
        }
    }

    fun formatPrice(price: Int): String {
        val formatter = NumberFormat.getInstance(Locale("es", "CO"))
        return formatter.format(price)
    }

}