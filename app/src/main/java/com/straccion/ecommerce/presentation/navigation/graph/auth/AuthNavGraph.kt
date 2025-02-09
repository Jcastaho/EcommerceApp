package com.straccion.ecommerce.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.auth.AuthScreen
import com.straccion.ecommerce.presentation.screens.auth.login.LoginScreen
import com.straccion.ecommerce.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navHostController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterScreen(navHostController)
        }
    }
}