package com.straccion.ecommerce.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.straccion.ecommerce.presentation.navigation.screen.roles.RolesScreen
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.straccion.ecommerce.presentation.screens.admin.home.AdminHomeScreen
import com.straccion.ecommerce.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.lis.AdminProductListScreen
import com.straccion.ecommerce.presentation.screens.client.home.ClientHomeScreen
import com.straccion.ecommerce.presentation.screens.profile.update.ProfileUpdateScreen
import com.straccion.ecommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ) {
        composable(route = AdminCategoryScreen.CategoryCreate.route) {
            AdminCategoryCreateScreen(navHostController)
        }
        composable(
            route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                AdminCategoryUpdateScreen(navHostController, categoryParam = it)
            }
        }
        composable(
            route = AdminCategoryScreen.ProducList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                AdminProductListScreen(navHostController, it)
            }
        }
        composable(
            route = AdminCategoryScreen.ProductCreate.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                AdminProductCreateScreen(navHostController, it)
            }
        }
    }
}