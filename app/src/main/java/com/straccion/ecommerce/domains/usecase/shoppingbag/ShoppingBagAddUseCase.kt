package com.straccion.ecommerce.domains.usecase.shoppingbag

import com.straccion.ecommerce.domains.model.ShoppingBagProduct
import com.straccion.ecommerce.domains.repository.ShoppingBagRepository

class ShoppingBagAddUseCase (private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repository.add(shoppingBagProduct)
    }
}