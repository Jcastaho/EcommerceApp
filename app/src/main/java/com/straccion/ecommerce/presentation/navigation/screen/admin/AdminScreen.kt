package com.straccion.ecommerce.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object CategoryList : AdminScreen(
        route = "admin/category/list",
        title = "Categorias",
        icon = Icons.AutoMirrored.Filled.List
    )
    data object ProductList : AdminScreen(
        route = "admin/produc/list",
        title = "Productos",
        icon = Icons.Default.ThumbUp
    )
    data object Profile : AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
