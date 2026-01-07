package com.example.ogrimorio.ui.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ogrimorio.R
import com.example.ogrimorio.ui.theme.Red
import com.example.ogrimorio.ui.theme.TryAgainButtonColor
import com.example.ogrimorio.ui.theme.White

@Composable
fun CriticsCard(
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit,
    onRollAgainClick: () -> Unit
) {
    Box(
        modifier = modifier.offset(y = 350.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.criticos),
            contentDescription = null
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { onCloseClick() },
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.x_metal_ico),
                    contentDescription = null
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Título",
                color = Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 30.dp, start = 10.dp, end = 10.dp)
            )
            Text(
                text = "DescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescrição",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .height(350.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(vertical = 30.dp, horizontal = 25.dp),

                )
            Button(
                onClick = { onRollAgainClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = TryAgainButtonColor
                )
            ) {
                Text(
                    text = "Rolar de novo",
                    color = White
                )
            }
        }
    }
}