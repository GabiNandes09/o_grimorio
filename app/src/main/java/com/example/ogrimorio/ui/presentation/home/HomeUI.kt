package com.example.ogrimorio.ui.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.R
import com.example.ogrimorio.ui.presentation.animations.TapHint
import com.example.ogrimorio.ui.presentation.background.BackgroundContainer
import com.example.ogrimorio.ui.presentation.home.components.CriticsCard
import com.example.ogrimorio.ui.presentation.home.components.OptionsBar
import com.example.ogrimorio.ui.presentation.home.components.TitleHome

@Composable
fun HomeUI() {
    BackgroundContainer(
        backgroundRes = R.drawable.fundo
    ) {
        var typeSelected by rememberSaveable { mutableIntStateOf(0) }
        var categorySelected by rememberSaveable { mutableIntStateOf(-1) }
        var isSelected by rememberSaveable { mutableStateOf(false) }
        var canDiceClick by rememberSaveable { mutableStateOf(false) }
        var wasDiceClicked by rememberSaveable { mutableStateOf(false) }
        var showingCrit by rememberSaveable { mutableStateOf(false) }

        val dadaoRes = if (typeSelected == 0) R.drawable.dadao_sucesso else R.drawable.dadao_erro

        val firstOptions = listOf(
            "Acerto",
            "Erro"
        )

        val secondOptions = listOf(
            "Concussão",
            "Perfurante",
            "Cortante"
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = { TitleHome() }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.wrapContentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OptionsBar(
                        options = firstOptions,
                        modifier = Modifier.wrapContentSize()
                    ) { selected ->
                        typeSelected = selected
                        isSelected = true
                    }

                    AnimatedVisibility(
                        visible = isSelected,
                        enter = slideInVertically { -it / 2 } + fadeIn(),
                        exit = slideOutVertically { it / 2 } + fadeOut()
                    ) {
                        OptionsBar(
                            options = secondOptions,
                            modifier = Modifier.wrapContentSize()
                        ) { selected ->
                            categorySelected = selected
                            canDiceClick = true
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .offset(y = (-30).dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                IconButton(
                    onClick = {
                        if (categorySelected >= 0) {
                            wasDiceClicked = true
                            showingCrit = true
                        }
                    },
                    modifier = Modifier.size(250.dp)
                ) {
                    Image(
                        painter = painterResource(dadaoRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(250.dp),
                        contentScale = ContentScale.Fit
                    )
                }
                AnimatedVisibility(
                    visible = canDiceClick && !wasDiceClicked,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    TapHint(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .offset(x = 50.dp, y = 50.dp)
                    )
                }
            }

            AnimatedVisibility(
                visible = showingCrit,
                enter = slideInVertically { it },
                exit = slideOutVertically { it }
            ) {
                CriticsCard(
                    onCloseClick = { showingCrit = false },
                    onRollAgainClick = { }
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview() {
    HomeUI()
}