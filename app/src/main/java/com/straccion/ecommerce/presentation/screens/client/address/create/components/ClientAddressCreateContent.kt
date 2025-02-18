package com.straccion.ecommerce.presentation.screens.client.address.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.components.DefaultButton
import com.straccion.ecommerce.presentation.components.DefaultTextField
import com.straccion.ecommerce.presentation.screens.client.address.create.ClientAddressCreateViewModel

@Composable
fun ClientAddressCreateContent(
    paddingValues: PaddingValues,
    viewModel: ClientAddressCreateViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.map),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(
                topEnd = 0.dp, topStart = 0.dp
            ), colors = CardColors(
                contentColor = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.68f
                ),
                containerColor = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.1f
                ),
                disabledContentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = stringResource(R.string.titulo_address_create),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.address,
                    onValueChange = {
                        viewModel.onAddressInput(it)
                    },
                    label = stringResource(R.string.addres_create),
                    icon = Icons.Default.LocationOn,
                )
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.neighborhood,
                    onValueChange = {
                        viewModel.onNeighborhoodInput(it)
                    },
                    label = stringResource(R.string.neighboord_create),
                    icon = Icons.Outlined.Info,
                )
                Spacer(modifier = Modifier.height(40.dp))
                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    text = "Guardar dirección",
                    onClick = {
                        viewModel.createAddress()
                    }
                )
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}
