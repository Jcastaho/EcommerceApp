package com.straccion.ecommerce.presentation.screens.admin.product.update

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.straccion.ecommerce.presentation.screens.admin.product.update.components.UpdateProduct


@Composable
fun AdminProductUpdateScreen(navHostController: NavHostController, productParam: String) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Producto",
                upAvailable = true,
                navHostController = navHostController
            )
        },
    ) {
        AdminProductUpdateContent(it)
    }
    UpdateProduct()
}
