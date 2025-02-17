package com.straccion.ecommerce.domains.usecase.products

import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.repository.ProductsRepository
import java.io.File


class UpdateProductWithImageUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product, files: List<File?>) =
        repository.updateWithImage(id, product, files)
}