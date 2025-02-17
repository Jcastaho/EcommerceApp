package com.straccion.ecommerce.presentation.screens.client.products.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.navigation.screen.client.ClientProductScreen
import com.straccion.ecommerce.presentation.screens.client.products.list.ClientProductListViewModel

@Composable
fun ClientProductListItem(
    product: Product,
    navHostController: NavHostController,
    viewModel: ClientProductListViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { navHostController.navigate(route = ClientProductScreen.ProductDetail.passProduct(product.toJson())) }
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultAsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(12.dp)),
                imageUrl = product.image1 ?: ""
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = product.description,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$"+ viewModel.formatPrice(product.price),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}