package com.example.apporeo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apporeo.screens.HomeScreen
import com.example.apporeo.screens.InsertData
import com.example.apporeo.screens.InsertScreen
import com.example.apporeo.screens.LoginScreen
import com.example.apporeo.screens.PassRecoverScreen
import com.example.apporeo.screens.SplashScreen


@Composable
fun AppNavigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route)
    {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = AppScreens.PassRecoverScreen.route) {
            PassRecoverScreen(navController)
        }
        composable(route = AppScreens.InsertScreen.route) {
            InsertScreen(navController)
        }
        /*composable("login") {
            LoginScreen(navController)
        }*/

    }

}