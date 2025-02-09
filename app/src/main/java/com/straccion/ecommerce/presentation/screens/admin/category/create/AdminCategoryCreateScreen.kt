package com.straccion.ecommerce.presentation.screens.admin.category.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.straccion.ecommerce.presentation.screens.admin.category.create.components.AdminCategoryCreateContent

@Composable
fun AdminCategoryCreateScreen() {
    Scaffold {
        AdminCategoryCreateContent(it)
    }
}