package com.straccion.ecommerce.domains.usecase.shoppingbag

data class ShoppingBagUseCase (
    val addUseCase: ShoppingBagAddUseCase,
    val deleteUseCase: ShoppingBagDeleteUseCase,
    val findAllUseCase: ShoppingBagFindAllUseCase
)