package com.straccion.ecommerce.presentation.screens.admin.product.create.mapper

import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.presentation.screens.admin.product.create.AdminProductCreateState

fun AdminProductCreateState.toProduct(): Product {
    return Product (
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}