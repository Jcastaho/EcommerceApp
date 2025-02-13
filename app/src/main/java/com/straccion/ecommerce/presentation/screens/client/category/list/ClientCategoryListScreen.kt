package com.straccion.ecommerce.presentation.screens.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.screens.client.category.list.components.GetCategories

@Composable
fun ClientCategoryListScreen(navHostController: NavHostController) {
    Scaffold {
        GetCategories(navHostController = navHostController, paddingValues = it)
    }
}
