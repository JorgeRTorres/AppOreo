package com.example.apporeo.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.apporeo.navigation.BottonNavigationItem

@Composable
fun HomeScreen(navController: NavController){
    BottonNavigationBar()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottonNavigationBar() {

    var itemSeleccionado = remember { mutableStateOf(0) }
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottonNavigationItem().listaItems().forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = itemSeleccionado.value == index,
                        label = { Text(
                            text = item.nombre,
                            fontSize = 12.sp,
                        ) },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icono),
                                contentDescription = item.nombre,
                                modifier = Modifier.size(35.dp)
                            )
                        },
                        onClick = {
                            itemSeleccionado.value = index
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination()) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        })
    {}

}



