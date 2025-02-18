package com.straccion.ecommerce.presentation.screens.client.address.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.straccion.ecommerce.presentation.screens.client.address.list.components.ClientAddressListContent
import com.straccion.ecommerce.presentation.screens.client.address.list.components.GetAddress

@Composable
fun ClientAddressListScreen(
    navHostController: NavHostController,
    viewModel: ClientAddressListViewModel = hiltViewModel()
) {
    viewModel.getSessionData()
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mis Direcciones",
                navHostController = navHostController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navHostController.navigate(route = ShoppingBagScreen.AddressCreate.route)
                }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        GetAddress(it)
    }
}

