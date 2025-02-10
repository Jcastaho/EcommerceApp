package com.straccion.ecommerce.presentation.screens.admin.category.update

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.components.DefaultTopBar
import com.straccion.ecommerce.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.straccion.ecommerce.presentation.screens.admin.category.create.components.CreateCategory
import com.straccion.ecommerce.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.straccion.ecommerce.presentation.screens.admin.category.update.components.UpdateCategory

@Composable
fun AdminCategoryUpdateScreen(navHostController: NavHostController, categoryParam: String) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.titulo_category_update),
                upAvailable = true,
                navHostController = navHostController
            )
        }
    ) {
        AdminCategoryUpdateContent(it)
    }
    UpdateCategory()
}