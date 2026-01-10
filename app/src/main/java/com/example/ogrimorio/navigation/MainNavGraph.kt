package com.example.ogrimorio.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ogrimorio.ui.presentation.home.HomeUI
import com.example.ogrimorio.ui.presentation.personalize.PersonaliseUI

fun NavGraphBuilder.mainNavGraph(navController: NavController){
    navigation(
        startDestination = NavConstants.HOME,
        route = NavConstants.MAIN_GRAPH
    ){
        composable(NavConstants.HOME) {
            HomeUI()
        }
        composable(NavConstants.PERSONALIZAR) {
            PersonaliseUI()
        }
    }
}