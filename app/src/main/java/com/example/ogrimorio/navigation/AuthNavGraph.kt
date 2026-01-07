package com.example.ogrimorio.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ogrimorio.ui.presentation.login.LoginUI

fun NavGraphBuilder.authNavGraph(navController: NavController){
    navigation(
        startDestination = NavConstants.LOGIN,
        route = NavConstants.AUTH_GRAPH
    ){
        composable(NavConstants.LOGIN) {
            LoginUI { navController.navigate(NavConstants.MAIN_GRAPH)  }
        }
    }
}