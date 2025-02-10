package com.straccion.ecommerce.domains.usecase.categories

import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.repository.CategoryRepository
import java.io.File

class UpdateWithImageCategoryUseCase (private val repository: CategoryRepository) {
    suspend operator fun invoke(id: String, category: Category, file: File) =
        repository.updateWithImage(id, category, file)
}