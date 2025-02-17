package com.straccion.ecommerce.presentation.navigation.screen.client


sealed class ClientProductScreen(val route: String) {
    data object ProductDetail : ClientProductScreen("client/products/detail/{product}") {
        fun passProduct(product: String) = "client/products/detail/$product"
    }
}
