package com.yolkie.uikit

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yolkie.uikit.ui.theme.UIKitTheme

@Composable
fun ParallaxScrollingScreen(
    modifier: Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState),
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Android logo",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(300.dp)
                .parallaxLayoutModifier(scrollState, 2, startHeight = 300, stopHeight = 50)
                .alpha(((300 - scrollState.value.toFloat()) / 2) / 300)
        )

        Text(
            text = stringResource(id = R.string.example_long_text),
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 8.dp),
            )
    }
}

fun Modifier.parallaxLayoutModifier(scrollState: ScrollState, rate: Int, startHeight: Int = 0, stopHeight: Int = 0) =
    layout { measurable, constraints ->
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
        ParallaxScrollingScreen(modifier = Modifier.fillMaxSize())
    }
}