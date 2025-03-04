package com.example.testtask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.MAIN_SCREEN) {
        composable(Screens.MAIN_SCREEN) {  }
    }
}
