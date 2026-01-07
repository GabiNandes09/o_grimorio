package com.example.ogrimorio.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavGraph(navController: NavController){
    navigation(
        startDestination = NavConstants.LOGIN,
        route = NavConstants.AUTH_GRAPH
    ){
        composable(NavConstants.LOGIN) {

        }
    }
}