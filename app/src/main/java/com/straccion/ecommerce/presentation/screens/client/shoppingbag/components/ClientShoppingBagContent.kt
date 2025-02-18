package com.straccion.ecommerce.presentation.screens.client.shoppingbag.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.straccion.ecommerce.domains.model.ShoppingBagProduct

@Composable
fun ClientShoppingBagContent(
    paddingValues: PaddingValues,
    shoppingBag: MutableList<ShoppingBagProduct>
) {

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(items = shoppingBag) { shoppingBagProduct ->
            ClientShoppingBagItem(shoppingBagProduct)
        }
    }

}
