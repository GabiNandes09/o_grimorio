package com.example.ogrimorio.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ogrimorio.R
import com.example.ogrimorio.ui.presentation.background.BackgroundContainer
import com.example.ogrimorio.ui.presentation.login.components.LoginButton
import com.example.ogrimorio.ui.presentation.login.components.TitleLogin

@Composable
fun LoginUI(
    onLoginSucess: () -> Unit
) {
    BackgroundContainer(
        backgroundRes = R.drawable.fundo
    ) {
        Scaffold(
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleLogin()
                LoginButton {
                    onLoginSucess()
                }
            }
        }
    }
}