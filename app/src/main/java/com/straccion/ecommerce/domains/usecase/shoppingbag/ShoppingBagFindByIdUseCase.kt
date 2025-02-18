package com.straccion.ecommerce.domains.usecase.shoppingbag

import com.straccion.ecommerce.domains.repository.ShoppingBagRepository

class ShoppingBagFindByIdUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) = repository.findById(id)
}