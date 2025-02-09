package com.straccion.ecommerce.presentation.screens.admin.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.straccion.ecommerce.presentation.navigation.screen.admin.AdminScreen

@Composable
fun AdminBottomBar(navHostController: NavHostController) {
    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile,
    )

    val navBackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any{ it.route == currentDestination?.route}

    if (bottomBarDestination){
        NavigationBar{
            screens.forEach{screen->
                AdminBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navHostController = navHostController
                )
            }
        }
    }
}
