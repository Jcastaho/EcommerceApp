package com.straccion.ecommerce.presentation.screens.admin.category.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.straccion.ecommerce.presentation.screens.admin.category.create.components.CreateCategory

@Composable
fun AdminCategoryCreateScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.titulo_category),
                upAvailable = true,
                navHostController = navHostController
            )
        }
    ) {
        AdminCategoryCreateContent(it)
    }
    CreateCategory()
}