package com.example.ogrimorio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.ogrimorio.datastore.AppPreferences
import com.example.ogrimorio.navigation.AppNavHost
import com.example.ogrimorio.ui.presentation.background.BackgroundContainer
import com.example.ogrimorio.ui.presentation.components.DrawerDefault
import com.example.ogrimorio.ui.theme.OGrimorioTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val prefs = koinInject<AppPreferences>()

            val backgroundId by prefs.backgroundId.collectAsState(R.drawable.fundo)

            OGrimorioTheme {
                BackgroundContainer(
                    backgroundRes = backgroundId
                ) {
                    DrawerDefault(
                        modifier = Modifier.wrapContentWidth(),
                        onOptionClick = { route ->
                            navController.navigate(route) {
                                launchSingleTop = true
                            }
                        }
                    ) { onMenuClick ->
                        Scaffold(
                            containerColor = Color.Transparent,
                            topBar = {
                                TopAppBar(
                                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                                    title = { },
                                    navigationIcon = {
                                        IconButton(onClick = onMenuClick) {
                                            Image(
                                                painter = painterResource(R.drawable.book_ico),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                )
                            }
                        ) { padding ->
                            AppNavHost(
                                navController = navController,
                                modifier = Modifier.padding(padding)
                            )
                        }
                    }
                }
            }

        }
    }
}
