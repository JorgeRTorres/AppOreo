package com.example.apporeo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.apporeo.screens.BottomNavigationBar
import androidx.navigation.compose.composable
import com.example.apporeo.screens.HomeMenuScreen
import com.example.apporeo.screens.InsertScreen
import com.example.apporeo.screens.LogoutDialogScreen
import com.example.apporeo.screens.PerfilScreen

@Composable
fun MenuNavigation()
{
    val navController = rememberNavController()
    BottomNavigationBar(navController)
    NavHost(navController = navController, startDestination =  MenuScreens.HomeMenuScreen.route)
    {
        composable(MenuScreens.HomeMenuScreen.route){
            HomeMenuScreen(navController)
        }
        composable(MenuScreens.PerfilScreen.route){
            PerfilScreen(navController)
        }
        composable(MenuScreens.InsertScreen.route){
            InsertScreen(navController)
        }
        composable(MenuScreens.LogoutScreen.route) {
            LogoutDialogScreen(
                onConfirm = {
                    navController.popBackStack()
                },
                onDismiss = {
                    navController.popBackStack()
                }
            )
        }
    }
}
