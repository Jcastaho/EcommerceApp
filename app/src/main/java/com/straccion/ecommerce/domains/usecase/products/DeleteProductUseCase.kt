package com.straccion.ecommerce.domains.usecase.products

import com.straccion.ecommerce.domains.repository.ProductsRepository


class DeleteProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}