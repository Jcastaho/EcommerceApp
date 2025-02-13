package com.straccion.ecommerce.domains.usecase.categories

import com.straccion.ecommerce.domains.repository.CategoryRepository

class DeleteCategoryUseCase (private val repository: CategoryRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}