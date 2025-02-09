package com.straccion.ecommerce.presentation.screens.auth.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.screens.auth.login.components.Login
import com.straccion.ecommerce.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginScreen(navHostController: NavHostController) {
    Scaffold(
        content = {paddingValues ->
            LoginContent(navHostController, paddingValues)
        }
    )
    Login(navHostController)
}