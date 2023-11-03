package com.nomaan.composeexample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScalableBox(
    boxColor: Color = Color.White,
    outlineColor: Color = Color.Unspecified,
    boxOnClick: () -> Unit = {},
    modifier: Modifier,
    content: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(boxColor)
            .border(width = 2.dp, color = outlineColor, shape = RoundedCornerShape(12.dp))
            .clickable { boxOnClick }
            .padding(16.dp)
    ) {
        content()
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 200, heightDp = 200)
fun BlueBoxFieldPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScalableBox(
            outlineColor = Color.Blue,
            boxOnClick = {},
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 200, heightDp = 200)
fun RedRectangleFieldPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScalableBox(
            boxColor = Color.Transparent,
            outlineColor = Color.Red,
            boxOnClick = {},
            modifier = Modifier
                .width(160.dp)
                .height(80.dp)
        )
    }
}