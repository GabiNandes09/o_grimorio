package com.example.ogrimorio.ui.presentation.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.ogrimorio.R

@Composable
fun TitleLogin(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo_sem_fundo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(R.drawable.titulo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}