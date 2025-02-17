package com.straccion.ecommerce.domains.usecase.products

import com.straccion.ecommerce.domains.repository.ProductsRepository


class FindAllUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke() = repository.findAll()
}