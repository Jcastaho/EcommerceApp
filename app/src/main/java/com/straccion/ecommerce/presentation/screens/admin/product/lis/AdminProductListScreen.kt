package com.straccion.ecommerce.presentation.screens.admin.product.lis

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.straccion.ecommerce.presentation.screens.admin.product.lis.components.AdminProductListContent

@Composable
fun AdminProductListScreen(
    navHostController: NavHostController,
    categoryParam: String
) {
    val categoryParse = Category.fromJson(categoryParam).toJson()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 30.dp),
                onClick = {
                    navHostController.navigate(
                        route = AdminCategoryScreen.ProductCreate.passCategory(
                            categoryParse
                        )
                    )
                }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        AdminProductListContent(it)
    }
}
