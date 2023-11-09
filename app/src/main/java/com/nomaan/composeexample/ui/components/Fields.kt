package com.nomaan.composeexample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nomaan.composeexample.R

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 151, heightDp = 90)
fun OneLineNameFieldPreview() {
    Column(Modifier.padding(16.dp)) {
        ScalableBox(
            boxColor = Color.Yellow,
            modifier = Modifier,
            outlineColor = Color.Red
        ) {
            Text(text = "Hello Android!")
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 300, heightDp = 200)
fun ParagraphFieldPreview() {
    Column(Modifier.padding(16.dp)) {
        ScalableBox(
            boxColor = Color.DarkGray,
            outlineColor = Color.Yellow,
            modifier = Modifier
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                        "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                color = Color.White
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 300, heightDp = 200)
fun ImageAndTextFieldPreview() {
    Column(Modifier.padding(16.dp)) {
        ScalableBox(
            boxColor = Color.White,
            outlineColor = Color.Black,
            modifier = Modifier
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.8f))
                )
                Text(text = "Lorem ipsum dolor")
            }
        }
    }
}

@Composable
fun SpiralBox(childrenToRender: Int, colors: Array<Color>, rotationValue: Float = 0F) {
    val boxColor = remember { mutableStateOf(colors.random()) }
    val outlineColor = remember { mutableStateOf(colors.random()) }

    ScalableBox(
        boxColor = boxColor.value,
        outlineColor = outlineColor.value,
        boxOnClick = {
            boxColor.value = colors.random()
            outlineColor.value = colors.random()
        },
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .rotate(rotationValue)
    ) {
        if (childrenToRender > 0) {
            SpiralBox(childrenToRender - 1, colors, 8F)
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 300, heightDp = 300)
fun SpiralBoxRecursive() {
    val colors = arrayOf(
        Color.Black,
        Color.Blue,
        Color.Red,
        Color.Yellow,
        Color.White,
        Color.Green
    )

    Column {
        SpiralBox(7, colors)
    }
}
