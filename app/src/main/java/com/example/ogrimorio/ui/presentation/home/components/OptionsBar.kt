package com.example.ogrimorio.ui.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.R

@Composable
fun OptionsBar(
    modifier: Modifier = Modifier,
    options: List<String>,
    itemSelected: (Int) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        var selectedIndex by rememberSaveable { mutableIntStateOf(-1) }

        Image(
            painter = painterResource(R.drawable.pergaminho),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
        )
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            itemsIndexed(options) { index, item ->
                OptionsCell(
                    modifier = Modifier.width(150.dp),
                    text = item,
                    ico = R.drawable.sword_ico,
                    isChecked = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                        itemSelected(index)
                    }
                )
            }
        }
    }
}