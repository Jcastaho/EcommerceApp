package com.straccion.ecommerce.domains.usecase.shoppingbag

import com.straccion.ecommerce.domains.repository.ShoppingBagRepository

class ShoppingBagFindAllUseCase(private val repository: ShoppingBagRepository) {
    operator fun invoke() = repository.findAll()
}