package com.example.ogrimorio.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ogrimorio.ui.presentation.login.components.LoginButton
import com.example.ogrimorio.ui.presentation.login.components.TitleLogin

@Composable
fun LoginUI(
    onLoginSucess: () -> Unit
) {
    Column(
        modifier = Modifier
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