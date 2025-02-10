package com.straccion.ecommerce.presentation.navigation.screen.admin


sealed class AdminCategoryScreen(val route: String) {
    data object CategoryCreate: AdminCategoryScreen("admin/category/create")
    data object CategoryUpdate: AdminCategoryScreen("admin/category/update/{category}"){
        fun passCategory(category: String) = "admin/category/update/$category"
    }
}
