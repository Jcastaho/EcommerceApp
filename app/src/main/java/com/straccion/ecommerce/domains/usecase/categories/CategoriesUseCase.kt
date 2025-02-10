package com.straccion.ecommerce.domains.usecase.categories

data class CategoriesUseCase(
    val createCategoryUseCase: CreateCategoryUseCase,
    val getCategoriesUseCase: GetCategoriesUseCase,
    val updateCategoryUseCase: UpdateCategoryUseCase,
    val updateWithImageCategoryUseCase: UpdateWithImageCategoryUseCase
)
