package com.example.ogrimorio.ui.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ogrimorio.models.DrawerItem
import com.example.ogrimorio.navigation.NavConstants
import kotlinx.coroutines.launch


@Composable
fun DrawerDefault(
    modifier: Modifier = Modifier,
    onOptionClick: (String) -> Unit,
    content: @Composable (
        onMenuClick: () -> Unit
    ) -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = modifier,
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Opções", style = MaterialTheme.typography.titleMedium)

                Spacer(Modifier.height(16.dp))

                DrawerContent { onOptionClick(it) }
            }
        }
    ) {
        content {
            scope.launch {
                drawerState.open()
            }
        }
    }
}


@Composable
fun DrawerContent(
    onNavigate: (String) -> Unit
) {
    val options = listOf(
        DrawerItem("Personalizar", NavConstants.PERSONALIZAR),
        DrawerItem("Histórico", NavConstants.HISTÓRICO),
        DrawerItem("Gerenciar", NavConstants.GERENCIAR),
        DrawerItem("Estatísticas", NavConstants.ESTATÍSTICAS)
    )
    options.forEach {
        NavigationDrawerItem(
            label = { Text(it.name) },
            selected = false,
            onClick = { onNavigate(it.route) }
        )
        HorizontalDivider()
    }
}