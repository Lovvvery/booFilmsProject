package com.example.apifilmstest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(startDestination: String = "main", viewModel: MovieViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = startDestination) {
        composable("main") {
            MainScreen(navController, viewModel)
        }
        composable("detail/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: return@composable
            DetailScreen(movieId = movieId, viewModel = viewModel, navController = navController)
        }
    }
}
