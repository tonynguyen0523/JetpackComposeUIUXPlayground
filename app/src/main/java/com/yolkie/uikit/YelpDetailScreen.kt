package com.yolkie.uikit

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.drawWithContent
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
import com.yolkie.uikit.uikits.buttons.IconTextButton
import com.yolkie.uikit.uikits.buttons.IconTextOutlinedButton
import com.yolkie.uikit.uikits.texts.SmallHeaderTitleText

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
            .background(Color.LightGray.copy(alpha = 0.1f))
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
                    .background(Color.Black)
                    .alpha(((600 - scrollState.value.toFloat()) / 2) / 300)
            ) {
                Image(
                    painterResource(id = R.drawable.metro_exterior),
                    contentDescription = "Android logo",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(300.dp)
                        .drawWithContent {
                            drawContent()
                            drawRect(
                                color = Color.Black.copy(alpha = 0.5f)
                            )
                        }
                )

                Text(
                    text = "Metro Diner",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .align(Alignment.BottomStart)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .padding(horizontal = 20.dp)
                    ) {
                        Text(
                            text = "$$ • Breakfast",
                            style = MaterialTheme.typography.titleSmall
                        )

                        Text(
                            text = "Open now • 7:00 AM - 2:00 PM",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.Gray
                        )

                        Text(
                            text = "A local breakfast and brunch spot in the heart of downtown",
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(
                                rememberScrollState()
                            )
                            .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        IconTextButton(
                            icon = Icons.Outlined.Email,
                            text = "Add Review",
                            backgroundColor = Color.Red,
                        ) {
                            
                        }

                        IconTextOutlinedButton(
                            icon = Icons.Outlined.Place,
                            text = "Map",
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        ) {

                        }

                        IconTextOutlinedButton(
                            icon = Icons.Outlined.Phone,
                            text = "Phone",
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        ) {

                        }

                        IconTextOutlinedButton(
                            icon = Icons.Outlined.Home,
                            text = "Website",
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        ) {

                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = "Info",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 30.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        SmallHeaderTitleText(
                            headerText = "Hours",
                            text = "Open until 7:00pm"
                        )

                        HorizontalDivider()

                        SmallHeaderTitleText(
                            headerText = "Website",
                            text = "Metro Diner"
                        )

                        HorizontalDivider()

                        SmallHeaderTitleText(
                            headerText = "Call",
                            text = "(904) 123-4567"
                        )

                        HorizontalDivider()

                        SmallHeaderTitleText(
                            headerText = "Description",
                            text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n"
                        )


                    }
                }
            }

        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .shadow(elevation = getElevation(scrollState), spotColor = Color.Transparent),
            color = Color.Black.copy(
                alpha = getValidAlpha(((scrollState.value.toFloat()) / 2) / 300)
            ),
        ) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        color = Color.White.copy(alpha = getValidAlpha(((scrollState.value.toFloat()) / 2) / 300)),
                        text = "Metro Diner",
                        style = MaterialTheme.typography.titleMedium

                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black.copy(alpha = 0f)
                ),
                navigationIcon = {
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Arrow",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = "Back Arrow",
                            tint = Color.White
                        )
                    }

                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Outlined.Share,
                            contentDescription = "Back Arrow",
                            tint = Color.White
                        )
                    }
                }
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