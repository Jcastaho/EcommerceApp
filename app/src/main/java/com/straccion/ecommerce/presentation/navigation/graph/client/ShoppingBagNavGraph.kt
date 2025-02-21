package com.straccion.ecommerce.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.straccion.ecommerce.presentation.screens.client.address.create.ClientAddressCreateScreen
import com.straccion.ecommerce.presentation.screens.client.address.list.ClientAddressListScreen
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