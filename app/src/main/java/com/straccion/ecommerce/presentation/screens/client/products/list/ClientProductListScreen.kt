package com.straccion.ecommerce.presentation.screens.client.products.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.straccion.ecommerce.presentation.screens.client.products.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen() {
    Scaffold {
        ClientProductListContent(it)
    }
}
