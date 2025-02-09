package com.straccion.ecommerce.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object CategoryList : ClientScreen(
        route = "client/category/list",
        title = "Categorias",
        icon = Icons.AutoMirrored.Filled.List
    )
    data object ProductList : ClientScreen(
        route = "client/produc/list",
        title = "Productos",
        icon = Icons.Default.ThumbUp
    )
    data object Profile : ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
