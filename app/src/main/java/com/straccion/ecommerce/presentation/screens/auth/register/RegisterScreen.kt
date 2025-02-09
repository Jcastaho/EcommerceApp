package com.straccion.ecommerce.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.auth.register.components.Register
import com.straccion.ecommerce.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.registrarse),
                upAvailable = true,
                navHostController = navHostController
            )
        }
    ) { paddingValues ->
        RegisterContent(paddingValues)
    }
    Register(navHostController)
}
