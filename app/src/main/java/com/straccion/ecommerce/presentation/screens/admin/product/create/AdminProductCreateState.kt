package com.straccion.ecommerce.presentation.screens.admin.product.create

data class AdminProductCreateState (
    val name: String = "",
    val description: String = "",
    val idCategory: Int = 0,
    val image1: String = "",
    val image2: String = "",
    val price: Int = 0
)