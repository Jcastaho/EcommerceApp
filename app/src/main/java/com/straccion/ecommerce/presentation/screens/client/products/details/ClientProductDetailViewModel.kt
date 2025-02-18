package com.straccion.ecommerce.presentation.screens.client.products.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.model.ShoppingBagProduct
import com.straccion.ecommerce.domains.usecase.shoppingbag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)

    var productImage = listOf(product.image1 ?: "", product.image2 ?: "")

    var quantity by mutableIntStateOf(0)
        private set

    var price by mutableIntStateOf(0)
        private set

    init {
        getShoppingBagProduct()
    }

    fun add() {
        quantity += 1
        price = product.price * quantity
    }

    fun remove() {
        if (quantity > 0) {
            quantity -= 1
            price = product.price * quantity
        }
    }



    fun getShoppingBagProduct() = viewModelScope.launch {
        val result = shoppingBagUseCase.findByIdUseCase(product.id ?: "")
        quantity = result?.quantity ?: 0
        price = product.price * quantity
    }

    fun saveItem() = viewModelScope.launch {
        if (quantity > 0) {
            val shoppingBagProduct = ShoppingBagProduct(
                id = product.id ?: "",
                name = product.name,
                price = product.price,
                image1 = product.image1 ?: "",
                idCategory = product.idCategory,
                quantity = quantity
            )
            shoppingBagUseCase.addUseCase(shoppingBagProduct)
        }
    }


}