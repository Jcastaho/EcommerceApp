package com.straccion.ecommerce.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.straccion.ecommerce.presentation.navigation.graph.root.RootNavGraph
import com.straccion.ecommerce.presentation.ui.theme.EcommerceTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                EcommerceTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        navHostController = rememberNavController()
                        RootNavGraph(navHostController = navHostController)
                    }
                }
            }
        }
    }
}

