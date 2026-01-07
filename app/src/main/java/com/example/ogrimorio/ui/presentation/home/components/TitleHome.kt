package com.example.ogrimorio.ui.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.R

@Composable
fun TitleHome(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(top = 30.dp),
        horizontalArrangement = Arrangement.Center
    ) {
       Image(
           painter = painterResource(R.drawable.titulo),
           contentDescription = null
       )
    }
}