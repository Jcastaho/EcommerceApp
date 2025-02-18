package com.straccion.ecommerce.presentation.screens.client.address.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.straccion.ecommerce.domains.model.Address


@Composable
fun ClientAddressListContent(
    paddingValues: PaddingValues,
    addressList: List<Address>
) {
    LazyColumn(modifier = Modifier
        .padding(paddingValues)
    ) {
        items(items = addressList) {
            ClientAddressListItem(it)
        }

    }
}
