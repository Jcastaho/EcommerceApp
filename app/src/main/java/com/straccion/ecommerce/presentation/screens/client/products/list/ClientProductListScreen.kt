package com.straccion.ecommerce.presentation.screens.client.products.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.client.products.list.components.ClientProductListContent
import com.straccion.ecommerce.presentation.screens.client.products.list.components.GetProducts

@Composable
fun ClientProductListScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                navHostController = navHostController,
                upAvailable = true,
                enableActions = true
            )
        }
    ) {
        GetProducts(it, navHostController)
    }
}
