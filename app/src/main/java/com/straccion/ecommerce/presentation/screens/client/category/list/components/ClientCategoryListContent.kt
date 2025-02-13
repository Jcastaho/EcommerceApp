package com.straccion.ecommerce.presentation.screens.client.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.model.Category

@Composable
fun ClientCategoryListContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    categories: List<Category>
) {
    Text(
        modifier = Modifier.padding(paddingValues),
        text = "Categorylist Screen"
    )
    LazyColumn(modifier = Modifier
        .padding(paddingValues)
        .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(items = categories) {
            ClientCategoryListItem(navHostController, category = it)
        }
    }

}