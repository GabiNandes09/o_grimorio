package com.example.ogrimorio.ui.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.R

@Composable
fun OptionsCell(
    modifier: Modifier = Modifier,
    text: String,
    ico: Int,
    isChecked: Boolean,
    onClick: () -> Unit
) {
    val id = if (isChecked) R.drawable.selected_aba else R.drawable.aba

    Box(
        modifier = modifier.clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.width(120.dp).align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(ico),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )

            Spacer(Modifier.padding(6.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
private fun Prev() {
    OptionsCell(
        text = "Ataque a distancia",
        ico = R.drawable.x_metal_ico,
        isChecked = false,
        modifier = Modifier
            .width(150.dp)
            .height(50.dp)
    ) { }
}