package com.straccion.ecommerce.presentation.screens.client.products.listbycategory

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.client.products.listbycategory.components.GetProductsByCategory

@Composable
fun ClientProductListByCategoryScreen(
    navHostController: NavHostController,
    categoryParam: String
) {
    val categoryParse = Category.fromJson(categoryParam).toJson()
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de productos",
                navHostController = navHostController,
                upAvailable = true
            )
        }
    ) {
        GetProductsByCategory(it, navHostController)
    }
}
