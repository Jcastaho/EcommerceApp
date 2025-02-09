package com.straccion.ecommerce.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.roles.RolesScreen
import com.straccion.ecommerce.presentation.screens.admin.home.AdminHomeScreen
import com.straccion.ecommerce.presentation.screens.client.home.ClientHomeScreen
import com.straccion.ecommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navHostController)
        }
        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }
        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}