package com.straccion.ecommerce.presentation.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size


@Composable
fun DefaultAsyncImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    // Imagen principal
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .allowHardware(true)
            .crossfade(true)
            .size(Size.ORIGINAL)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .memoryCacheKey(imageUrl)
            .diskCacheKey(imageUrl)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = "Moto image"
    )
}
