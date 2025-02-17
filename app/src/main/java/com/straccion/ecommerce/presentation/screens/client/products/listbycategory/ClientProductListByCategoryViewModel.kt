package com.straccion.ecommerce.presentation.screens.client.products.listbycategory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.usecase.products.ProductsUseCase
import com.straccion.ecommerce.domains.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ClientProductListByCategoryViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase,
    private val savedStateHandle: SavedStateHandle

) : ViewModel() {


    var data = savedStateHandle.get<String>("category")//recupero los datos enviados

    var category = Category.fromJson(data!!)
    var productsResponse by mutableStateOf<Response<List<Product>>?>(null)
        private set

    var productsDeleteResponse by mutableStateOf<Response<Unit>?>(null)
        private set

    init {
        getProducts()
    }

    fun getProducts() = viewModelScope.launch {
        productsResponse = Response.Loading
        productsUseCase.findProductByCategory(category.id!!).collect(){
            productsResponse = it
        }
    }
    fun formatPrice(price: Int): String {
        val formatter = NumberFormat.getInstance(Locale("es", "CO"))
        return formatter.format(price)
    }

}