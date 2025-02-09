package com.straccion.ecommerce.presentation.screens.client.home


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.straccion.ecommerce.presentation.navigation.graph.client.ClientNavGraph
import com.straccion.ecommerce.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            ClientBottomBar(navHostController = navHostController)
        }
    ) {
        ClientNavGraph(navHostController = navHostController)
    }

}