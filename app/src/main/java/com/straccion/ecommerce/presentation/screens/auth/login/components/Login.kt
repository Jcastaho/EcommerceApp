package com.straccion.ecommerce.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.components.ProgressBar
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.screens.auth.login.LoginViewModel
import kotlinx.coroutines.delay

@Composable
fun Login(
    navHostController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    when (val response = viewModel.loginResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                viewModel.saveSession(response.data)
                delay(1000)
                if (response.data.user?.roles!!.size > 1) {
                    navHostController.navigate(route = Graph.ROLES){
                        popUpTo(Graph.AUTH){ inclusive = true}
                    }
                }else{//un solo rol
                    navHostController.navigate(route = Graph.CLIENT){
                        popUpTo(Graph.AUTH){ inclusive = true}
                    }
                }
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null){
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}