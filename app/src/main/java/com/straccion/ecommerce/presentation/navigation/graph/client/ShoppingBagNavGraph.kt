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
import com.straccion.ecommerce.presentation.navigation.screen.client.ClientProductScreen
import com.straccion.ecommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.straccion.ecommerce.presentation.screens.admin.product.list.AdminProductListScreen
import com.straccion.ecommerce.presentation.screens.admin.product.update.AdminProductUpdateScreen
import com.straccion.ecommerce.presentation.screens.client.address.create.ClientAddressCreateScreen
import com.straccion.ecommerce.presentation.screens.client.address.list.ClientAddressListScreen
import com.straccion.ecommerce.presentation.screens.client.products.details.ClientProductDetailScreen
import com.straccion.ecommerce.presentation.screens.client.products.listbycategory.ClientProductListByCategoryScreen
import com.straccion.ecommerce.presentation.screens.client.shoppingbag.ClientShoppingBagScreen

fun NavGraphBuilder.ShoppingBagNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ) {
        composable(route = ShoppingBagScreen.ShoppingBag.route) {
            ClientShoppingBagScreen(navHostController)
        }

        composable(route = ShoppingBagScreen.AddressList.route) {
            ClientAddressListScreen(navHostController)
        }

        composable(route = ShoppingBagScreen.AddressCreate.route) {
            ClientAddressCreateScreen(navHostController)
        }
    }
}