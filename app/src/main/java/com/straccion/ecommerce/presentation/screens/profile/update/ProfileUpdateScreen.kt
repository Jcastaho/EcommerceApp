package com.straccion.ecommerce.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.profile.update.components.ProfileUpdateContent
import com.straccion.ecommerce.presentation.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(
    navHostController: NavHostController,
    userParam: String
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navHostController = navHostController,
                upAvailable = true
            )
        }
    ) { paddingValues ->
        ProfileUpdateContent(paddingValues)
    }
    UpdateUser()
}