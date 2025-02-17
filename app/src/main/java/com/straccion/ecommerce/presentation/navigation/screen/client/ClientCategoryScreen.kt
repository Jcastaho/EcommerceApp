package com.straccion.ecommerce.presentation.navigation.screen.client


sealed class ClientCategoryScreen(val route: String) {
    data object ProducList : ClientCategoryScreen("client/category/products/list/{category}") {
        fun passCategory(category: String) = "client/category/products/list/$category"
    }
}
