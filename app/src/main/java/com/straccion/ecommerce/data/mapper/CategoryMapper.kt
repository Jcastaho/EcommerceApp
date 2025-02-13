package com.straccion.ecommerce.data.mapper

import com.straccion.ecommerce.data.datasource.local.entity.CategoryEntity
import com.straccion.ecommerce.domains.model.Category

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}

