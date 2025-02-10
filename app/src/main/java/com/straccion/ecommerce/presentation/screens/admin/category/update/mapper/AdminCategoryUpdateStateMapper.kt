package com.straccion.ecommerce.presentation.screens.admin.category.update.mapper

import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.presentation.screens.admin.category.update.AdminCategoryUpdateState

fun AdminCategoryUpdateState.toCategory():Category {
    return Category(
        name = name,
        description = description
    )
}