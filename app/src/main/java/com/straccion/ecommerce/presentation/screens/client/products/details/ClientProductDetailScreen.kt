package com.straccion.ecommerce.presentation.screens.client.products.details

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.screens.client.products.details.components.ClientProductDetailContent

@Composable
fun ClientProductDetailScreen(navHostController: NavHostController, productParam: String) {

    Scaffold() {
        ClientProductDetailContent(it)
    }

}
