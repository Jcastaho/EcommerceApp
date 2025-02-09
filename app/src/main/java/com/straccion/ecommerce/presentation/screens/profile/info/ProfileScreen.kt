package com.straccion.ecommerce.presentation.screens.profile.info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.screens.profile.info.components.ProfileContent

@Composable
fun ProfileScreen(navHostController: NavHostController) {
    Scaffold { paddingValues ->
        ProfileContent(paddingValues, navHostController)
    }
}