package com.straccion.ecommerce.presentation.screens.admin.product.update

data class AdminProductUpdateState (
    val id: String? = "",
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val idCategory: Int = 0,
    val image1: String = "",
    val image2: String = "",
    val imageToUpdate: MutableList<Int> = mutableListOf()
)