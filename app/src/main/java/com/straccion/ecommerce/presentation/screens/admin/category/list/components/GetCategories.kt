package com.straccion.ecommerce.presentation.screens.admin.category.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.components.ProgressBar
import com.straccion.ecommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun GetCategories(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: AdminCategoryListViewModel = hiltViewModel()
) {
    when (val response = viewModel.categoriesResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            AdminCategoryListContent(categories = response.data, paddingValues, navHostController)
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