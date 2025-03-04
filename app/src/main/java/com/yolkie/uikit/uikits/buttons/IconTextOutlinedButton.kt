package com.yolkie.uikit.uikits.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yolkie.uikit.ui.theme.UIKitTheme

@Composable
fun IconTextOutlinedButton(
    icon: ImageVector,
    text: String,
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, contentColor),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
            containerColor = backgroundColor
        )
    ) {
        Icon(
            icon,
            contentDescription = text
        )

        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun IconTextOutlinedButtonPreview() {
    UIKitTheme {
        IconTextOutlinedButton(
            icon = Icons.Outlined.Share,
            text = "Share",
            onClick = { /*TODO*/ }
        )
    }
}