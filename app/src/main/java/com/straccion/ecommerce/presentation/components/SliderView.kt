package com.straccion.ecommerce.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.straccion.ecommerce.presentation.screens.client.products.details.ClientProductDetailViewModel
import kotlinx.coroutines.delay

@Composable
fun SliderView(
    pagerState: PagerState,
    images: List<String>
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        val imageUrl = images.getOrNull(page)
        AsyncImage(
            model = imageUrl,
            contentDescription = "imagen  ${page + 1}",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}





