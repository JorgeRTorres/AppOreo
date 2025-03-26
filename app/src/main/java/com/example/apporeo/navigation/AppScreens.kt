package com.example.apporeo.navigation

sealed class AppScreens(val route: String)
{
    object SplashScreen: AppScreens("Splash_Screen")
    object LoginScreen: AppScreens("Login_Screen")
    object HomeScreen: AppScreens("Home_Screen")
    object PassRecoverScreen: AppScreens("Pass_Recover_Screen")
}
