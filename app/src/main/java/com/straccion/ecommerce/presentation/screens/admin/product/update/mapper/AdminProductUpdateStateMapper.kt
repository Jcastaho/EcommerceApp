package com.straccion.ecommerce.presentation.screens.admin.product.update.mapper

import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.presentation.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product {
    return Product (
        id = id,
        name = name,
        description = description,
        idCategory = idCategory,
        price = price,
        imageToUpdate = imageToUpdate.toList(),
        image1 = image1,
        image2 = image2
    )
}