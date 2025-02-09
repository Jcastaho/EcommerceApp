package com.straccion.ecommerce.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.straccion.ecommerce.presentation.navigation.graph.admin.AdminNavGraph
import com.straccion.ecommerce.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            AdminBottomBar(navHostController = navHostController)
        }
    ) {
        AdminNavGraph(navHostController = navHostController)
    }

}