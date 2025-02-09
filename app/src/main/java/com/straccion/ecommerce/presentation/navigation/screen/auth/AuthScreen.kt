package com.straccion.ecommerce.presentation.navigation.screen.auth

sealed class AuthScreen(val route: String) {
    data object Login: AuthScreen("login")
    data object Register: AuthScreen("register")
}
