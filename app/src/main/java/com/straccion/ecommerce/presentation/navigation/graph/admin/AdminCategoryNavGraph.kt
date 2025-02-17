package com.straccion.ecommerce.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.list.AdminProductListScreen
import com.straccion.ecommerce.presentation.screens.admin.product.update.AdminProductUpdateScreen

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
        composable(
            route = AdminCategoryScreen.ProductUpdate.route,
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {
                AdminProductUpdateScreen(navHostController, it)
            }
        }
    }
}