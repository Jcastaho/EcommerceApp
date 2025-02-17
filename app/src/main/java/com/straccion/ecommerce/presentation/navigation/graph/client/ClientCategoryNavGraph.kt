package com.straccion.ecommerce.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.straccion.ecommerce.presentation.navigation.screen.client.ClientCategoryScreen
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.list.AdminProductListScreen
import com.straccion.ecommerce.presentation.screens.admin.product.update.AdminProductUpdateScreen
import com.straccion.ecommerce.presentation.screens.client.products.listbycategory.ClientProductListByCategoryScreen

fun NavGraphBuilder.ClientCategoryNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProducList.route
    ) {
        composable(
            route = ClientCategoryScreen.ProducList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                ClientProductListByCategoryScreen(navHostController, it)
            }
        }

    }
}