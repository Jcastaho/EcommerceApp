package com.straccion.ecommerce.presentation.screens.client.products.listbycategory.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.model.Product

@Composable
fun ClientProductListByCategoryContent(
    products: List<Product>,
    paddingValues: PaddingValues,
    navHostController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 30.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = products
        ) { product ->
            ClientProductListByCategoryItem(product = product, navHostController = navHostController)
        }
    }

}
