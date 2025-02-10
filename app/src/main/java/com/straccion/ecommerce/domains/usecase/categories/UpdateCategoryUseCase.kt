package com.straccion.ecommerce.domains.usecase.categories

import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.repository.CategoryRepository
import java.io.File

class UpdateCategoryUseCase (private val repository: CategoryRepository) {
    suspend operator fun invoke(id: String, category: Category) = repository.update(id, category)
}