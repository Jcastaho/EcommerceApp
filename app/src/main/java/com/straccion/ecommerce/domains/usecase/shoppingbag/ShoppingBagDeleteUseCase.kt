package com.straccion.ecommerce.domains.usecase.shoppingbag

import com.straccion.ecommerce.domains.repository.ShoppingBagRepository

class ShoppingBagDeleteUseCase (private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) {
        repository.delete(id)
    }
}