package com.straccion.ecommerce.presentation.screens.client.address.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.client.address.create.components.ClientAddressCreateContent
import com.straccion.ecommerce.presentation.screens.client.address.create.components.CreateAddress

@Composable
fun ClientAddressCreateScreen(
    navHostController: NavHostController,
    viewModel: ClientAddressCreateViewModel = hiltViewModel()
) {
    viewModel.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva Dirección",
                upAvailable = true,
                navHostController
            )
        }
    ) {
        ClientAddressCreateContent(it)
    }
    CreateAddress()
}

