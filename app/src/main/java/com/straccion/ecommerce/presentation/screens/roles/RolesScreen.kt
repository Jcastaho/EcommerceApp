package com.straccion.ecommerce.presentation.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = { DefaultTopBar(title = "Selecciona un rol", upAvailable = false) }
    ) {paddinValues->
        RolesContent(paddinValues, navHostController = navHostController)
    }
}
