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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ogrimorio.R
import com.example.ogrimorio.database.dto.CriticalWithRelations
import com.example.ogrimorio.database.entity.CategoryEntity
import com.example.ogrimorio.database.entity.CriticalEntity
import com.example.ogrimorio.database.entity.TypeEntity
import com.example.ogrimorio.ui.theme.Red
import com.example.ogrimorio.ui.theme.TryAgainButtonColor
import com.example.ogrimorio.ui.theme.White

@Composable
fun CriticsCard(
    modifier: Modifier = Modifier,
    critical: CriticalWithRelations,
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onRollAgainClick() },
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(R.drawable.rerrole_ico),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Text(
                    text = critical.critical.name,
                    color = Red,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = { onCloseClick() }
                ) {
                    Image(
                        painter = painterResource(R.drawable.x_metal_ico),
                        contentDescription = null
                    )
                }
            }
            Text(
                text = critical.critical.effect,
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
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CriticsCard(
        critical = CriticalWithRelations(
            CriticalEntity(1, "TESTE", "Teste EFeito", 1, 2),
            TypeEntity(1, "Tipo"),
            CategoryEntity(1, "Categoria"),
        ),
        onCloseClick = {}
    ) { }
}