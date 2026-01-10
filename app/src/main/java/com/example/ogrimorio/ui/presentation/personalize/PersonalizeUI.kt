package com.example.ogrimorio.ui.presentation.personalize

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ogrimorio.R
import com.example.ogrimorio.ui.theme.Red
import com.example.ogrimorio.ui.theme.White
import com.example.ogrimorio.ui.theme.White_Trans
import com.example.ogrimorio.viewmodel.PersonalizeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PersonaliseUI() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val viewModel = koinViewModel<PersonalizeViewModel>()

        val selectedImageId by viewModel.backgroundId.collectAsState()
        val soundOff by viewModel.sound.collectAsState()

        val defaultOptions = listOf(
            R.drawable.fundo,
            R.drawable.fundo_login_0,
            R.drawable.fundo_login_2,
            R.drawable.fundo_login_3,
            R.drawable.fundo_login_4,
            R.drawable.fundo_login_5,
            R.drawable.fundo_login_6,
            R.drawable.fundo_login_7
        )

        Text(
            text = "Personalização",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )

        Text(
            text = "Deixe seu tomo com a sua cara",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = White_Trans
        )

        Box(
            modifier = Modifier
                .padding(20.dp)
                .border(1.dp, White_Trans, RoundedCornerShape(15.dp))
        ) {
            Image(
                painter = painterResource(selectedImageId),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(120.dp)
                    .padding(5.dp)
            )
        }

        LazyRow(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            items(defaultOptions) { item ->
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .border(
                            1.5.dp,
                            if (item == selectedImageId) Red else White_Trans,
                            RoundedCornerShape(15.dp)
                        )
                        .clickable { viewModel.setBackground(item) }
                ) {
                    Image(
                        painter = painterResource(item),
                        contentDescription = null,
                        modifier = Modifier
                            .height(75.dp)
                            .width(60.dp)
                            .padding(3.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = !soundOff,
                onCheckedChange = { viewModel.toggleSoundMode(!soundOff) }
            )
            Text(
                text = "Desativar som de rolagem",
                color = White_Trans
            )
        }
    }
}