package com.straccion.ecommerce.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.straccion.ecommerce.presentation.ui.theme.Blue500

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowForward,
    color: Color = Blue500
) {
    Button(
        modifier = modifier,
        onClick = {
            onClick()
        },
        colors = ButtonColors(
            contentColor =  MaterialTheme.colorScheme.onSurface,
            containerColor = color,
            disabledContainerColor = color,
            disabledContentColor =  MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(Modifier
            .fillMaxWidth()
            .padding(3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text.uppercase(),
                fontSize = 20.sp,
                color = Color.White,
            )
        }

    }
}