package com.straccion.ecommerce.presentation.screens.client.category.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage

@Composable
fun ClientCategoryListItem(
    navHostController: NavHostController,
    category: Category
) {
    Card(
        modifier = Modifier
            .padding(bottom = 15.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            DefaultAsyncImage(
                imageUrl = category.image ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                text = category.name.uppercase(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                text = category.description,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}