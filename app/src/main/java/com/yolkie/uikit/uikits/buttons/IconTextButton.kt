package com.yolkie.uikit.uikits.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yolkie.uikit.ui.theme.UIKitTheme

@Composable
fun IconTextButton(
    icon: ImageVector,
    text: String,
    backgroundColor: Color = Color.Gray,
    contentColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                icon,
                contentDescription = text
            )

            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParallaxScrollingPreview() {
    UIKitTheme {
        IconTextButton(
            icon = Icons.Outlined.Share,
            text = "Share",
            onClick = { /*TODO*/ }
        )
    }
}