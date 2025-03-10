package com.straccion.ecommerce.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.straccion.ecommerce.presentation.navigation.screen.client.ShoppingBagScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean,
    navHostController: NavHostController? = null,
    enableActions: Boolean = false
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            MaterialTheme.colorScheme.surface
        ),
        navigationIcon = {
            IconButton(onClick = {
                navHostController?.popBackStack()
            }) {
                if (upAvailable) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        },
        actions = {
            if (enableActions) {
                IconButton(onClick = {
                    navHostController?.navigate(route = ShoppingBagScreen.ShoppingBag.route)
                }) {
                    if (upAvailable) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    )
}