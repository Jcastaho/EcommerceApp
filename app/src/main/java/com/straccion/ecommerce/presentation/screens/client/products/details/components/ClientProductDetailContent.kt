package com.straccion.ecommerce.presentation.screens.client.products.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.presentation.components.DefaultButton
import com.straccion.ecommerce.presentation.components.DotsIndicator
import com.straccion.ecommerce.presentation.components.SliderView
import com.straccion.ecommerce.presentation.screens.client.products.details.ClientProductDetailViewModel


@Composable
fun ClientProductDetailContent(
    paddingValues: PaddingValues,
    viewModel: ClientProductDetailViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(pageCount = { viewModel.productImage.size })

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 40.dp)
            .fillMaxSize()
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
                    .background(MaterialTheme.colorScheme.background)// Aquí estableces el fondo blanco
            ) {
                SliderView(pagerState, viewModel.productImage)
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                DotsIndicator(
                    pageCount = viewModel.productImage.size,
                    currentPage = pagerState.currentPage
                )
            }
        }
    }
    // Aquí agregamos un Box que ocupa toda la pantalla para fijar el Card abajo
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
                .align(Alignment.BottomCenter), // Fija el Card en la parte inferior
            shape = RoundedCornerShape(
                topEnd = 40.dp, topStart = 40.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp),
                    text = viewModel.product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp),
                    text = "Description",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = viewModel.product.description,
                    fontSize = 15.sp
                )
                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp),
                    text = "Precio: ${viewModel.product.price}",
                    fontSize = 15.sp
                )
                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp),
                    text = "Tu Orden",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Cantidad: 0",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                Spacer(modifier = Modifier.height(140.dp))

                // Botón y contador
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                                viewModel.remove()
                            },
                            text = "-",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.surface
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = viewModel.quantity.toString(),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.surface
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            modifier = Modifier.clickable {
                                viewModel.add()
                            },
                            text = "+",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.surface
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    DefaultButton(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .width(200.dp),
                        text = "AGREGAR",
                        onClick = { viewModel.saveItem() }
                    )
                }
            }
        }
    }
}
