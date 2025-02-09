package com.straccion.ecommerce.presentation.screens.admin.product.lis

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.straccion.ecommerce.presentation.screens.admin.product.lis.components.AdminProductListContent
@Composable
fun AdminProductListScreen() {
    Scaffold {
        AdminProductListContent(it)
    }
}
