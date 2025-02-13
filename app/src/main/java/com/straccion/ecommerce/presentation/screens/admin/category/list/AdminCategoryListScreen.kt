package com.straccion.ecommerce.presentation.screens.admin.category.list

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
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.screens.admin.category.list.components.DeleteCategories
import com.straccion.ecommerce.presentation.screens.admin.category.list.components.GetCategories

@Composable
fun AdminCategoryListScreen(navHostController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 80.dp),
                onClick = {
                    navHostController.navigate(route = Graph.ADMIN_CATEGORY)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        GetCategories(it, navHostController = navHostController)
    }
    DeleteCategories()
}
