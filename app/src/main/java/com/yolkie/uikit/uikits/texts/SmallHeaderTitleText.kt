package com.yolkie.uikit.uikits.texts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.yolkie.uikit.ui.theme.Typography

@Composable
fun SmallHeaderTitleText(
    headerText: String, text: String
) {
    Column {
        Text(
            text = headerText,
            style = Typography.titleSmall,
            color = Color.Black
        )

        Text(
            text = text,
            color = Color.Black
        )
    }
}