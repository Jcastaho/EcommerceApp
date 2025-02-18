package com.straccion.ecommerce.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.graph.profile.ProfileNavGraph
import com.straccion.ecommerce.presentation.navigation.screen.client.ClientScreen
import com.straccion.ecommerce.presentation.screens.client.category.list.ClientCategoryListScreen
import com.straccion.ecommerce.presentation.screens.client.products.list.ClientProductListScreen
import com.straccion.ecommerce.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ){
        composable(route = ClientScreen.ProductList.route){
            ClientProductListScreen(navHostController)
        }
        composable(route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen(navHostController)
        }
        composable(route = ClientScreen.Profile.route){
            ProfileScreen(navHostController)
        }
        ProfileNavGraph(navHostController)
        ClientCategoryNavGraph(navHostController)
        ClientProductNavGraph(navHostController)
        ShoppingBagNavGraph(navHostController)
    }
}