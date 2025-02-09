package com.straccion.ecommerce.presentation.screens.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.straccion.ecommerce.domains.model.Rol
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.navigation.Graph

@Composable
fun RolesItem(rol: Rol, navHostController: NavHostController) {
    Column(modifier = Modifier.clickable {
        navHostController.navigate(route = rol.route) {
            popUpTo(route = Graph.ROLES) { inclusive = true }
        }
    }) {
        DefaultAsyncImage(rol.image, Modifier.size(150.dp))
        Text(
            text = rol.name.uppercase(),
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}
