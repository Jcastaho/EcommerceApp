package com.straccion.ecommerce.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.profile.ProfileDetailScreen
import com.straccion.ecommerce.presentation.navigation.screen.roles.RolesScreen
import com.straccion.ecommerce.presentation.screens.admin.home.AdminHomeScreen
import com.straccion.ecommerce.presentation.screens.client.home.ClientHomeScreen
import com.straccion.ecommerce.presentation.screens.profile.update.ProfileUpdateScreen
import com.straccion.ecommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ProfileNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.PROFILE +"/{user}",
        startDestination = ProfileDetailScreen.ProfileUpdate.route
    ){
        composable(
            route = ProfileDetailScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let { data ->
                ProfileUpdateScreen(navHostController, userParam = data)
            }
        }
    }
}