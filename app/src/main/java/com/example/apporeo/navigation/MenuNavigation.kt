package com.example.apporeo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.apporeo.screens.*

@Composable
fun MenuNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = MenuScreens.HomeMenuScreen.route,
        modifier = modifier
    ) {
        composable(MenuScreens.HomeMenuScreen.route) {
            HomeMenuScreen(navController)
        }
        composable(MenuScreens.InsertScreen.route) {
            InsertScreen(navController)
        }
        composable(MenuScreens.LogoutScreen.route) {
            LogoutDialogScreen(
                navController = navController,
                onDismiss = { navController.popBackStack() }
            )
        }
    }
}
