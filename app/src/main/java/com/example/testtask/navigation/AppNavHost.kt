package com.example.testtask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testtask.create.presentation.CreateScreen
import com.example.testtask.main.presentation.MainScreen
import com.example.testtask.note.presentation.NoteScreen


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.MainScreen) {
        composable<Screens.MainScreen> {
            MainScreen(navController)
        }
        composable<Screens.CreateScreen> {
            CreateScreen(navController)
        }

        composable<Screens.NoteScreen> {
            NoteScreen(navController)
        }
    }
}
