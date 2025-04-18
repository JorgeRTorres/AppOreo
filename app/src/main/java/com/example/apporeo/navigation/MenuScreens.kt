package com.example.apporeo.navigation

sealed class MenuScreens(val route: String)
{
    object HomeMenuScreen: MenuScreens("Home_Menu_Screen")
    object InsertScreen: MenuScreens("Insert_Screen")
    object LogoutScreen: MenuScreens("Logout_Screen")

}