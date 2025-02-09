package com.straccion.ecommerce.presentation.screens.profile.info.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.MainActivity
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.components.DefaultButton
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.navigation.screen.profile.ProfileDetailScreen
import com.straccion.ecommerce.presentation.screens.profile.info.ProfileViewModel


@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as? Activity
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .background(Color.Black.copy(alpha = 0.9f))
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.85f), // R
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(modifier = Modifier
                .align(Alignment.End)
                .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    viewModel.logout()
                    //reiniciar el main activity
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Icon(
                    modifier = Modifier.size(100.dp),
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Cerrar Sesion",
                    tint = Color.White
                )
            }
            if (!viewModel.user?.image.isNullOrBlank()) {
                DefaultAsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    imageUrl = viewModel.user?.image!!,
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(R.drawable.user_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop

                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp), shape = RoundedCornerShape(
                    topEnd = 40.dp, topStart = 40.dp
                ), colors = CardColors(
                    contentColor = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.68f
                    ),
                    containerColor = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.6f
                    ),
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface
                )
            ) {
                Column(modifier = Modifier.padding(30.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(50.dp),
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "${viewModel.user?.name  ?: ""} ${viewModel.user?.lastname  ?: ""}",
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                            Text(
                                text = stringResource(R.string.nombre_del_user),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(50.dp),
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = viewModel.user?.email ?: "",
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                            Text(
                                text = stringResource(R.string.correo),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(50.dp),
                            imageVector = Icons.Default.Phone,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = viewModel.user?.phone  ?: "",
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                            Text(
                                text = stringResource(R.string.telefono),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 80.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        DefaultButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            text = "actualizar datos",
                            onClick = {
                                navHostController.navigate(route = "${Graph.PROFILE}/${viewModel.user?.toJson()}")
                            }
                        )
                    }

                }
            }
        }

    }
}
