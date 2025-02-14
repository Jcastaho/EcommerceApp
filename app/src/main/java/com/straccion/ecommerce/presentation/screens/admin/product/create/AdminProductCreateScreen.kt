package com.straccion.ecommerce.presentation.screens.admin.product.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.admin.product.create.components.AdminProductCreateContent


@Composable
fun AdminProductCreateScreen(navHostController: NavHostController, categoryParam: String) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Producto",
                upAvailable = true,
                navHostController = navHostController
            )
        },
    ) {
        AdminProductCreateContent(it)
    }
}
