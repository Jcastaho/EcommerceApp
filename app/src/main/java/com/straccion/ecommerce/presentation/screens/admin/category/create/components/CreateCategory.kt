package com.straccion.ecommerce.presentation.screens.admin.category.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.components.ProgressBar
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.straccion.ecommerce.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun CreateCategory(
    viewModel: AdminCategoryCreateViewModel = hiltViewModel()
) {
    when (val response = viewModel.categoryResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current, "Los datos se han almacenado correctamente", Toast.LENGTH_LONG).show()
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