package com.straccion.ecommerce.presentation.navigation.screen.profile

sealed class ProfileDetailScreen(val route: String) {
    data object ProfileUpdate: ProfileDetailScreen("profile/update/{user}")
}
