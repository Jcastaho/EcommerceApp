package com.straccion.ecommerce.data.mapper

import com.straccion.ecommerce.data.datasource.local.entity.ShoppingBagProductEntity
import com.straccion.ecommerce.domains.model.ShoppingBagProduct


fun ShoppingBagProduct.toEntity(): ShoppingBagProductEntity {
    return ShoppingBagProductEntity(
        id = id,
        name = name,
        image1 = image1,
        price = price,
        idCategory = idCategory,
        quantity = quantity,
    )
}

fun ShoppingBagProductEntity.toShoppingBagProduct(): ShoppingBagProduct {
    return ShoppingBagProduct(
        id = id,
        name = name,
        image1 = image1,
        price = price,
        idCategory = idCategory,
        quantity = quantity,
    )
}