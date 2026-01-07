package com.example.ogrimorio.ui.presentation.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.R

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
    ) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier.size(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.open_button),
            contentDescription = "Ação"
        )
    }
}