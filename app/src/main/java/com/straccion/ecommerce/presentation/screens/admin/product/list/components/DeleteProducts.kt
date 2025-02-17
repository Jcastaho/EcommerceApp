package com.straccion.ecommerce.presentation.screens.admin.product.list.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.components.ProgressBar
import com.straccion.ecommerce.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun DeleteProducts(
    viewModel: AdminProductListViewModel = hiltViewModel()
) {
    when (val response = viewModel.productsDeleteResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(LocalContext.current, "El producto se elimino correctamente", Toast.LENGTH_LONG).show()

        }

        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}