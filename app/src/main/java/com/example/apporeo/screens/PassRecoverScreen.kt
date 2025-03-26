package com.example.apporeo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PassRecoverScreen(navController: NavController){
    var usuario = remember { mutableStateOf("") }
    var nuevaContrasena = remember { mutableStateOf("") }
    var confirmarContrasena = remember { mutableStateOf("") }
    var errorUsuario = remember { mutableStateOf(false) }
    var errorNuevaContrasena = remember { mutableStateOf(false) }
    var errorConfirmarContrasena = remember { mutableStateOf(false) }
    var errorNoCoinciden = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp), // Margen interno de 16dp
        horizontalAlignment = Alignment.CenterHorizontally, // Centra el contenido horizontalmente
        verticalArrangement = Arrangement.Center // Centra el contenido verticalmente
    )
    {}
}