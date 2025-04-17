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
            BottonNavigationItem("", R.drawable.home, MenuScreens.HomeMenuScreen.route),
            BottonNavigationItem("", R.drawable.user, MenuScreens.PerfilMenuScreen.route)

        )
        return lista;

    }

}


