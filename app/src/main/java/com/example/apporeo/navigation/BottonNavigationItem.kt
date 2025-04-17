package com.example.apporeo.navigation
import com.example.apporeo.R

data class BottonNavigationItem(

    val nombre: String = "",
    val icono: Int = 0,
    val route: String = ""

)
{
    fun listaItems(): MutableList<BottonNavigationItem>
    {
        var lista: MutableList<BottonNavigationItem>
        lista = mutableListOf(
            BottonNavigationItem("Home", R.drawable.home, MenuScreens.HomeMenuScreen.route),
            BottonNavigationItem("User", R.drawable.user, MenuScreens.PerfilMenuScreen.route),
            BottonNavigationItem("Insert", R.drawable.insertar, MenuScreens.PerfilMenuScreen.route),
            BottonNavigationItem("Logout", R.drawable.logout, "logout")


        )
        return lista;
    }

}


