package com.example.ogrimorio.ui.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.R
import com.example.ogrimorio.database.entity.TypeEntity
import com.example.ogrimorio.interfaces.OptionItem

@Composable
fun OptionsBar(
    modifier: Modifier = Modifier,
    options: List<OptionItem>,
    columns: Int = 2,
    itemSelected: (Int) -> Unit
) {
    var selectedId by rememberSaveable { mutableIntStateOf(-1) }

    val rows = options.chunked(columns)

    Box(
        modifier = modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.pergaminho),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            rows.forEach { row ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    row.forEach { item ->
                        OptionsCell(
                            modifier = Modifier
                                .width(160.dp)
                                .height(60.dp),
                            text = item.name,
                            ico = R.drawable.sword_ico,
                            isChecked = selectedId == item.id,
                            onClick = {
                                selectedId = item.id ?: 0
                                itemSelected(selectedId)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    OptionsBar(
        options = listOf(TypeEntity(1, "Ataque a distanciaaaaaaaaaaaaa"))
    ) { }
    
}
