package com.straccion.ecommerce.presentation.screens.client.shoppingbag

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.ShoppingBagProduct
import com.straccion.ecommerce.domains.usecase.shoppingbag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ClientShoppingBagViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase
): ViewModel() {

    var shoppingBag = mutableStateListOf<ShoppingBagProduct>()
        private set

    var total by mutableStateOf(0.0)
        private set

//    init {
//        getShoppingBag()
//    }



    fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findAllUseCase().collect(){
            shoppingBag.clear()
            shoppingBag.addAll(it)
            getTotal()
        }
    }

    fun addItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        shoppingBagProduct.quantity += 1
        shoppingBagUseCase.addUseCase(shoppingBagProduct)
        getTotal()
    }
    fun SubtractItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        if (shoppingBagProduct.quantity > 1) {
            shoppingBagProduct.quantity -= 1
            shoppingBagUseCase.addUseCase(shoppingBagProduct)
            getTotal()
        }
    }

    fun deletetem(id: String) = viewModelScope.launch {
        shoppingBagUseCase.deleteUseCase(id)
        getTotal()
    }

    fun getTotal(){
        total = 0.0
        shoppingBag.forEach{
            total += (it.price * it.quantity)
        }
    }
    fun formatPrice(price: Int): String {
        val formatter = NumberFormat.getInstance(Locale("es", "CO"))
        return formatter.format(price)
    }
}