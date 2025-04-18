package com.example.apporeo.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.apporeo.navigation.AppScreens
import com.example.apporeo.navigation.BottonNavigationItem
import com.example.apporeo.navigation.MenuNavigation

/*@Composable
fun HomeScreen(navController: NavController) {
    BottonNavigationBar(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottonNavigationBar(navController: NavController) {
    val itemSeleccionado = remember { mutableStateOf(0) }
    val showLogoutDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottonNavigationItem().listaItems().forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = itemSeleccionado.value == index,
                        label = {
                            Text(
                                text = item.nombre,
                                fontSize = 12.sp,
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icono),
                                contentDescription = item.nombre,
                                modifier = Modifier.size(35.dp)
                            )
                        },
                        onClick = {
                            if (item.route == "logout") {
                                showLogoutDialog.value = true
                            } else {
                                itemSeleccionado.value = index
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination()) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                    )
                }
            }
        }
    ) {
        if (showLogoutDialog.value) {
            LogoutDialogScreen(
                onConfirm = {
                    showLogoutDialog.value = false
                    navController.navigate("login") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onDismiss = {
                    showLogoutDialog.value = false
                }
            )
        }
    }
}*/

@Composable
fun HomeScreen(navController: NavController){
    MenuNavigation()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navController: NavController){
    var itemSeleccionado = remember { mutableIntStateOf(0) }
    val showLogoutDialog = remember { mutableStateOf(false) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar =
        {
            NavigationBar { BottonNavigationItem().listaItems().forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = itemSeleccionado.intValue == index,
                    label = { Text(text = item.nombre, fontSize = 12.sp) },
                    icon = { Icon(painterResource(item.icono), contentDescription = "", modifier = Modifier.size(35.dp)) },
                    onClick = {
                        itemSeleccionado.intValue = index
                        navController.navigate(item.route)
                        {
                            popUpTo(item.route)
                            {
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
    {
        if (showLogoutDialog.value) {
            LogoutDialogScreen(
                onConfirm = {
                    showLogoutDialog.value = false
                    navController.navigate("login") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onDismiss = {
                    showLogoutDialog.value = false
                }
            )
        }
    }
}