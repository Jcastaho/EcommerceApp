package com.straccion.ecommerce.presentation.screens.admin.category.list.components

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
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminCategoryScreen

@Composable
fun AdminCategoryListItem(
    category: Category,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .height(80.dp)
    ) {
        Row() {
            DefaultAsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                imageUrl = category.image ?: "",
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
                        text = category.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Text(
                        text = category.description,
                        fontSize = 18.sp,
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
                                route = AdminCategoryScreen.CategoryUpdate.passCategory(
                                    category.toJson()
                                )
                            )
                        },
                    painter = painterResource(R.drawable.edit),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .weight(1f),
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