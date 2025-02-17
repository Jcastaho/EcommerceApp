package com.straccion.ecommerce.domains.usecase.products

import com.straccion.ecommerce.domains.repository.ProductsRepository


class FindProductByCategoryUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(idCategory: String) = repository.findByCategory(idCategory)
}