package com.straccion.ecommerce.presentation.navigation.screen.roles

sealed class RolesScreen(val route: String) {
    data object Roles: RolesScreen("roles")
}
