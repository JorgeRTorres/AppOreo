package com.example.apporeo.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.apporeo.navigation.BottonNavigationItemsProvider
import com.example.apporeo.navigation.MenuNavigation

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val selectedItemIndex = remember { mutableStateOf(0) }
    val items = BottonNavigationItemsProvider.getItems()

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex.value == index,
                        label = { Text(text = item.nombre, fontSize = 12.sp) },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icono),
                                contentDescription = item.nombre,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        onClick = {
                            selectedItemIndex.value = index
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        MenuNavigation(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}
