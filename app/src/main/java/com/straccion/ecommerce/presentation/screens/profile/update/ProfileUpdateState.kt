package com.straccion.ecommerce.presentation.screens.profile.update

data class ProfileUpdateState(
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val image: String? = null
)