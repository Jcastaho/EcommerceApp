package com.straccion.ecommerce.presentation.screens.client.shoppingbag.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.components.DefaultButton
import com.straccion.ecommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.straccion.ecommerce.presentation.screens.client.shoppingbag.ClientShoppingBagViewModel

@Composable
fun ClientShoppingBagBottomBar(
    navHostController: NavHostController,
    viewModel: ClientShoppingBagViewModel = hiltViewModel()
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
            .background(color = colorResource(R.color.blue_700)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Total",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = "$ ${viewModel.formatPrice(viewModel.total.toInt())}",
                fontSize = 17.sp
            )
        }
        DefaultButton(
            modifier = Modifier.width(200.dp),
            onClick = { navHostController.navigate(route = ShoppingBagScreen.AddressList.route) },
            text = "Comprar"
        )
    }
}
