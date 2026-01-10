package com.example.ogrimorio.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavConstants.AUTH_GRAPH,
        modifier = modifier
    ) {
        authNavGraph(navController)
        mainNavGraph(navController)
    }
}