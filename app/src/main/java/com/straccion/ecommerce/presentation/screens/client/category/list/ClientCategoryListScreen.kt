package com.straccion.ecommerce.presentation.screens.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.straccion.ecommerce.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun ClientCategoryListScreen() {
    Scaffold {
        ClientCategoryListContent(it)
    }
}
