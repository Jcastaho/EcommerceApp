package com.straccion.ecommerce.presentation.screens.client.address.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.components.ProgressBar
import com.straccion.ecommerce.presentation.screens.client.address.list.ClientAddressListViewModel

@Composable
fun GetAddress(
    paddingValues: PaddingValues,
    viewModel: ClientAddressListViewModel = hiltViewModel()
) {
    when (val response = viewModel.addressResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            ClientAddressListContent(paddingValues, response.data)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null){
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}