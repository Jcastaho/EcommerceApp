package com.straccion.ecommerce.presentation.screens.admin.category.create.mapper

import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory():Category {
    return Category(
        name = name,
        description = description
    )
}