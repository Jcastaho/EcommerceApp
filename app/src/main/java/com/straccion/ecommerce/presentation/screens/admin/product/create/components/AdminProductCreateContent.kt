package com.straccion.ecommerce.presentation.screens.admin.product.create.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.straccion.ecommerce.R
import com.straccion.ecommerce.presentation.components.DefaultAsyncImage
import com.straccion.ecommerce.presentation.components.DefaultButton
import com.straccion.ecommerce.presentation.components.DefaultTextField
import com.straccion.ecommerce.presentation.components.DialogCapturePicture
import com.straccion.ecommerce.presentation.screens.admin.product.create.AdminProductCreateViewModel
import com.straccion.ecommerce.presentation.ui.theme.Blue500

@Composable
fun AdminProductCreateContent(
    paddingValues: PaddingValues,
    viewModel: AdminProductCreateViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val activity = context as Activity
    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }
    val stateDialogImageNumber = remember { mutableStateOf(1) }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { viewModel.takePhoto(context, activity, stateDialogImageNumber.value) },
        pickImage = { viewModel.pickImage(stateDialogImageNumber.value) }
    )
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                if (state.image1.isNotBlank()) {
                    DefaultAsyncImage(
                        modifier = Modifier
                            .size(215.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .clickable { stateDialog.value = true },
                        imageUrl = state.image1,
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .clickable {
                                stateDialog.value = true
                                stateDialogImageNumber.value = 1
                            },
                        painter = painterResource(R.drawable.image_add),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                if (state.image2.isNotBlank()) {
                    DefaultAsyncImage(
                        modifier = Modifier
                            .size(215.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .clickable { stateDialog.value = true },
                        imageUrl = state.image2,
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .clickable {
                                stateDialog.value = true
                                stateDialogImageNumber.value = 2
                            },
                        painter = painterResource(R.drawable.image_add),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(
                topEnd = 0.dp, topStart = 0.dp
            ), colors = CardColors(
                contentColor = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.68f
                ),
                containerColor = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.1f
                ),
                disabledContentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Agregar a categoria: ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Blue500
                    )
                    Text(
                        text = viewModel.category.name,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = {
                        viewModel.onNameInput(it)
                    },
                    label = stringResource(R.string.nombre_producto),
                    icon = Icons.AutoMirrored.Filled.List,
                )
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = {
                        viewModel.onDescriptionInput(it)
                    },
                    label = stringResource(R.string.descripcion_producto),
                    icon = Icons.Outlined.Info,
                )
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.price.toString(),
                    onValueChange = {
                        viewModel.onPriceInput(it)
                    },
                    label = stringResource(R.string.precio_producto),
                    icon = Icons.Outlined.Info,
                    keyboardType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.height(40.dp))
                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    text = "Crear Producto",
                    onClick = {
                        //viewModel.createCategory()
                    }
                )
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}
