package com.straccion.ecommerce.domains.usecase.products

import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.repository.ProductsRepository


class UpdateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product) = repository.update(id, product)
}