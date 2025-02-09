package com.straccion.ecommerce.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.straccion.ecommerce.presentation.ui.theme.Blue500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit,
) {
    if (state.value) {
        BasicAlertDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = { state.value = false }
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.wrapContentSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Selecciona una opción",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp)
                            .align(Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier.width(130.dp),
                            onClick = {
                                state.value = false
                                pickImage()
                            },
                            colors = ButtonColors(
                                contentColor = MaterialTheme.colorScheme.onSurface,
                                containerColor = Blue500,
                                disabledContainerColor = Blue500,
                                disabledContentColor = MaterialTheme.colorScheme.onSurface
                            )
                        )
                        {
                            Text(
                                text = "Galeria",
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(15.dp))
                        Button(
                            modifier = Modifier.width(130.dp),
                            onClick = {
                                state.value = false
                                takePhoto()
                            },
                            colors = ButtonColors(
                                contentColor = MaterialTheme.colorScheme.onSurface,
                                containerColor = Blue500,
                                disabledContainerColor = Blue500,
                                disabledContentColor = MaterialTheme.colorScheme.onSurface
                            )
                        )
                        {
                            Text(
                                text = "Tomar foto",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
