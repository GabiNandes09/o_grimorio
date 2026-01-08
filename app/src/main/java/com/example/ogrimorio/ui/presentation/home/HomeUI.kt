package com.example.ogrimorio.ui.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.ogrimorio.database.dto.CriticalWithRelations
import com.example.ogrimorio.ui.presentation.animations.TapHint
import com.example.ogrimorio.ui.presentation.background.BackgroundContainer
import com.example.ogrimorio.ui.presentation.home.components.CriticsCard
import com.example.ogrimorio.ui.presentation.home.components.OptionsBar
import com.example.ogrimorio.ui.presentation.home.components.TitleHome
import com.example.ogrimorio.ui.theme.White_Trans
import com.example.ogrimorio.viewmodel.HomeViewmodel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeUI() {
    BackgroundContainer(
        backgroundRes = R.drawable.fundo
    ) {
        val viewmodel = koinViewModel<HomeViewmodel>()

        val types by viewmodel.types.collectAsState()
        val categories by viewmodel.categories.collectAsState()
        val criticalRolled by viewmodel.criticalRolled.collectAsState()

        var visibleCritical by remember { mutableStateOf<CriticalWithRelations?>(null) }

        LaunchedEffect(criticalRolled) {
            if (criticalRolled != null) {
                visibleCritical = criticalRolled
            }
        }

        var typeSelected by rememberSaveable { mutableIntStateOf(0) }
        var categorySelected by rememberSaveable { mutableIntStateOf(0) }

        var isTypeSelected by rememberSaveable { mutableStateOf(false) }
        var canDiceClick by rememberSaveable { mutableStateOf(false) }
        var wasDiceClicked by rememberSaveable { mutableStateOf(false) }

        val dadaoRes = if (typeSelected == 0) R.drawable.dadao_sucesso else R.drawable.dadao_erro

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
                        options = types,
                        modifier = Modifier.wrapContentSize()
                    ) { idSelected ->
                        typeSelected = idSelected
                        isTypeSelected = true
                    }

                    AnimatedVisibility(
                        visible = isTypeSelected,
                        enter = slideInVertically { -it / 2 } + fadeIn(),
                        exit = slideOutVertically { it / 2 } + fadeOut()
                    ) {
                        OptionsBar(
                            options = categories,
                            modifier = Modifier.wrapContentSize()
                        ) { idSelected ->
                            categorySelected = idSelected
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
                        if (categorySelected > 0 && typeSelected > 0) {
                            wasDiceClicked = true
                            viewmodel.makeARoll(
                                typeSelected,
                                categorySelected
                            )
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
                            .offset(x = 50.dp, y = (-30).dp)
                    )
                }

                if (canDiceClick) {
                    Text(
                        text = "Toque para selar o destino",
                        color = White_Trans
                    )
                }
            }
            AnimatedVisibility(
                visible = criticalRolled != null,
                enter = slideInVertically { it },
                exit = slideOutVertically { it }
            ) {
                visibleCritical?.let { critical ->
                    CriticsCard(
                        critical = critical,
                        onCloseClick = { viewmodel.rollReset() },
                        onRollAgainClick = {
                            viewmodel.makeARoll(typeSelected, categorySelected)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    HomeUI()
}