package com.straccion.ecommerce.presentation.screens.client.shoppingbag

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.client.shoppingbag.components.ClientShoppingBagBottomBar
import com.straccion.ecommerce.presentation.screens.client.shoppingbag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(
    navHostController: NavHostController,
    viewModel: ClientShoppingBagViewModel = hiltViewModel()
) {
    viewModel.getShoppingBag()
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mi Carrito",
                upAvailable = true,
                navHostController
            )
        },
        bottomBar = {
            ClientShoppingBagBottomBar(navHostController)
        }
    ) {
        ClientShoppingBagContent(it, viewModel.shoppingBag)
    }

}
