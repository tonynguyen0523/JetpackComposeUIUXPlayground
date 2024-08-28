package com.yolkie.uikit

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yolkie.uikit.ui.theme.UIKitTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YelpDetailScreen(
    modifier: Modifier,
    onBackClicked: () -> Unit = { }
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .parallaxLayoutModifier(scrollState, 2, startHeight = 300, stopHeight = 50)
                    .alpha(((600 - scrollState.value.toFloat()) / 2) / 300)
                    .background(Color.Gray)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Android logo",
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .height(300.dp)
                )

                Text(
                    text = "Yelp Detail Screen Example Playground",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .align(Alignment.BottomStart)
                )
            }

            Text(
                text = stringResource(id = R.string.example_long_text),
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 20.dp),
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .shadow(elevation = getElevation(scrollState), spotColor = Color.Transparent),
            color = Color.White.copy(
                alpha = getValidAlpha(((scrollState.value.toFloat()) / 2) / 300)
            ),
        ) {
            CenterAlignedTopAppBar(
                title = { Text(
                    color = Color.Black.copy(alpha = getValidAlpha(((scrollState.value.toFloat()) / 2) / 300)),
                    text = "Yelp Detail Screen"
                )},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White.copy(alpha = 0f)
                ),
                navigationIcon = {
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back Arrow")
                    }
                },
            )
        }
    }
}

fun getValidAlpha(alpha: Float): Float {
    return if (alpha > 1) {
        1f
    } else if (alpha < 0) {
        0f
    } else {
        alpha
    }
}

fun getElevation(scrollState: ScrollState, maxScrollValue: Int = 300, max: Dp = 10.dp): Dp {
    return if (scrollState.value >= maxScrollValue) {
        max
    } else {
        0.dp
    }
}

fun Modifier.parallaxLayoutModifier(
    scrollState: ScrollState,
    rate: Int,
    startHeight: Int = 0,
    stopHeight: Int = 0
) = layout { measurable, constraints ->
        Log.d("ParallaxScrolling", "ScrollState: ${scrollState.value}")

        val placeable = measurable.measure(constraints)

        val height = if (rate > 0) scrollState.value / rate else scrollState.value
        Log.d("ParallaxScrolling", "Placeable height: $height")

        layout(placeable.width, placeable.height) {
            if (height <= startHeight.minus(stopHeight)) {
                Log.d("ParallaxScrolling", "Placeable height updated: $height")
                placeable.place(0, height)
            } else {
                placeable.place(0, startHeight.minus(stopHeight))
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun ParallaxScrollingPreview() {
    UIKitTheme {
        YelpDetailScreen(modifier = Modifier.fillMaxSize())
    }
}