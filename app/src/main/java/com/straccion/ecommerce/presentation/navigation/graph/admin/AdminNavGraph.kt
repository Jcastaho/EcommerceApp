package com.straccion.ecommerce.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.graph.profile.ProfileNavGraph
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminScreen
import com.straccion.ecommerce.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.straccion.ecommerce.presentation.screens.admin.product.lis.AdminProductListScreen
import com.straccion.ecommerce.presentation.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ){
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen(navHostController)
        }
        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen(navHostController)
        }
        composable(route = AdminScreen.Profile.route){
            ProfileScreen(navHostController)
        }
        ProfileNavGraph(navHostController)
        AdminCategoryNavGraph(navHostController)
    }
}