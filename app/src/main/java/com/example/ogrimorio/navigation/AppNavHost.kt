package com.example.ogrimorio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavConstants.AUTH_GRAPH
    ){
        authNavGraph(navController)
    }
}