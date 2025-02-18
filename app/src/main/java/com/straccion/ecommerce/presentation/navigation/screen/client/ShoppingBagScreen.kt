package com.straccion.ecommerce.presentation.navigation.screen.client


sealed class ShoppingBagScreen(val route: String) {
    data object ShoppingBag : ShoppingBagScreen("client/shoppin_bag")
    data object AddressList : ShoppingBagScreen("client/address/list")
    data object AddressCreate : ShoppingBagScreen("client/address/create")

}
