// BottonNavigationItem.kt
package com.example.apporeo.navigation
import com.example.apporeo.R


data class BottonNavigationItem(
    val nombre: String,
    val icono: Int,
    val route: String
)

object BottonNavigationItemsProvider {
    fun getItems(): List<BottonNavigationItem> = listOf(
        BottonNavigationItem("Home", R.drawable.home, MenuScreens.HomeMenuScreen.route),
        BottonNavigationItem("Insert", R.drawable.insertar, MenuScreens.InsertScreen.route),
        BottonNavigationItem("Logout", R.drawable.logout, MenuScreens.LogoutScreen.route)
    )
}



