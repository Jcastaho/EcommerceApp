package com.straccion.ecommerce.presentation.navigation.screen.admin


sealed class AdminCategoryScreen(val route: String) {
    data object CategoryCreate : AdminCategoryScreen("admin/category/create")
    data object CategoryUpdate : AdminCategoryScreen("admin/category/update/{category}") {
        fun passCategory(category: String) = "admin/category/update/$category"
    }

    data object ProducList : AdminCategoryScreen("admin/category/products/list/{category}") {
        fun passCategory(category: String) = "admin/category/products/list/$category"
    }

    data object ProductCreate : AdminCategoryScreen("admin/category/products/create/{category}") {
        fun passCategory(category: String) = "admin/category/products/create/$category"
    }

    data object ProductUpdate : AdminCategoryScreen("admin/category/products/update/{product}") {
        fun passProduct(product: String) = "admin/category/products/update/$product"
    }
}
