package com.straccion.ecommerce.presentation.screens.profile.update.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.MainActivity
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.components.DefaultButton
import com.straccion.ecommerce.presentation.components.DefaultTextField
import com.straccion.ecommerce.presentation.components.DialogCapturePicture
import com.straccion.ecommerce.presentation.navigation.Graph
import com.straccion.ecommerce.presentation.screens.profile.update.ProfileUpdateViewModel
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local


@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileUpdateContent(
    paddingValues: PaddingValues,
    viewModel: ProfileUpdateViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val activity = context as Activity

    val state = viewModel.state
    val stateDialog = remember { mutableStateOf(false) }
    viewModel.resultingActivityHandler.handle()

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { viewModel.takePhoto(context, activity) },
        pickImage = { viewModel.pickImage() }
    )
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
            Spacer(modifier = Modifier.height(50.dp))
            if (!state.image.isNullOrBlank()) {
                DefaultAsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .clickable { stateDialog.value = true }
                        .align(Alignment.CenterHorizontally),
                    imageUrl = state.image,
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .clickable { stateDialog.value = true }
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
                    .wrapContentHeight(),
                shape = RoundedCornerShape(
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
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = {
                            viewModel.onNameInput(it)
                        },
                        label = stringResource(R.string.nombre),
                        icon = Icons.Default.Person,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastname,
                        onValueChange = {
                            viewModel.onLastnameInput(it)
                        },
                        label = stringResource(R.string.apellido),
                        icon = Icons.Outlined.Person,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = {
                            viewModel.onPhoneInput(it)
                        },
                        label = stringResource(R.string.telefono),
                        icon = Icons.Default.Phone,
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "Actualizar",
                        onClick = {
                            viewModel.onUpdate()
                        }
                    )
                }
            }
        }

    }
}
