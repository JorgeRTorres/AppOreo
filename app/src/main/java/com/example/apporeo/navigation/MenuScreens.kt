package com.example.apporeo.navigation

sealed class MenuScreens(val route: String)
{
    object HomeMenuScreen: MenuScreens("Home_Menu_Screen")
    object BuscarMenuScreen: MenuScreens("Buscar_Menu_Screen")
    object AgregarMenuScreen: MenuScreens("Agregar_Menu_Screen")
    object NotificionesMenuScreen: MenuScreens("Notificaciones_Menu_Screen")
    object PerfilMenuScreen: MenuScreens("Perfil_Menu_Screen")

}