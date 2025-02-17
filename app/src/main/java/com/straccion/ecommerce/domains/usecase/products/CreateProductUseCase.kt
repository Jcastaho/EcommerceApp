package com.straccion.ecommerce.domains.usecase.products

import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.repository.ProductsRepository
import java.io.File

class CreateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(product: Product, files: List<File>) = repository.create(product, files)
}