package com.straccion.ecommerce.domains.usecase.categories

import com.straccion.ecommerce.domains.repository.CategoryRepository

class GetCategoriesUseCase (private val repository: CategoryRepository) {
    suspend operator fun invoke() = repository.getCategories()
}