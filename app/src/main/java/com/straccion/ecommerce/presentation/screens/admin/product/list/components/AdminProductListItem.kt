package com.straccion.ecommerce.presentation.screens.admin.product.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.straccion.ecommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.straccion.ecommerce.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun AdminProductListItem(
    product: Product,
    navHostController: NavHostController,
    viewModel: AdminProductListViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .height(100.dp)
    ) {
        Row() {
            DefaultAsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                imageUrl = product.image1 ?: "",
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = product.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Text(
                        text = product.description,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 20.dp),
                        text = "$"+ viewModel.formatPrice(product.price),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }

            }
            Column {
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            navHostController.navigate(
                                route = AdminCategoryScreen.ProductUpdate.passProduct(
                                    product.toJson()
                                )
                            )
                        },
                    painter = painterResource(R.drawable.edit),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .weight(1f)
                        .clickable {
                            viewModel.deleteProducts(product.id ?: "")
                        },
                    painter = painterResource(R.drawable.trash),
                    contentDescription = null
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
    HorizontalDivider(
        color = Color.LightGray,
        thickness = 0.5.dp
    )

}