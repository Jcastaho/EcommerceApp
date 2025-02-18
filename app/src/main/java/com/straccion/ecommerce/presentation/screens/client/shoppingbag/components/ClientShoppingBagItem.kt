package com.straccion.ecommerce.presentation.screens.client.shoppingbag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.R
import com.straccion.ecommerce.domains.model.ShoppingBagProduct
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.screens.client.shoppingbag.ClientShoppingBagViewModel

@Composable
fun ClientShoppingBagItem(
    shoppingBagProduct: ShoppingBagProduct,
    viewModel: ClientShoppingBagViewModel = hiltViewModel()
) {
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DefaultAsyncImage(
            imageUrl = shoppingBagProduct.image1,
            modifier = Modifier
                .size(85.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.padding(start = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = shoppingBagProduct.name.uppercase(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.onSurface),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    modifier = Modifier.clickable {
                        viewModel.SubtractItem(shoppingBagProduct)
                    },
                    text = "-",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.surface
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = shoppingBagProduct.quantity.toString(),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.surface
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    modifier = Modifier.clickable {
                        viewModel.addItem(shoppingBagProduct)
                    },
                    text = "+",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.surface
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = viewModel.formatPrice(shoppingBagProduct.quantity * shoppingBagProduct.price)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { viewModel.deletetem(shoppingBagProduct.id) },
                painter = painterResource(R.drawable.trash),
                contentDescription = ""
            )

        }
    }
}