package com.straccion.ecommerce.domains.usecase.categories

import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.repository.CategoryRepository
import java.io.File

class CreateCategoryUseCase (private val repository: CategoryRepository) {
    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}