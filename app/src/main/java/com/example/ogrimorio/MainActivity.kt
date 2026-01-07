package com.example.ogrimorio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.ogrimorio.navigation.AppNavHost
import com.example.ogrimorio.ui.theme.OGrimorioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            OGrimorioTheme {
                AppNavHost(navController)
            }
        }
    }
}