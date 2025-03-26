package com.example.apporeo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apporeo.navigation.AppScreens

@Composable
fun PassRecoverScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Recuperar Contraseña", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            label = { Text("Ingresa tu usuario") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Nueva contraseña") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Confirmar contraseña") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button (
            onClick = {},
            modifier = Modifier.width(220.dp)
        ) {
            Text(text = "Actualizar Contraseña")
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = {}) {
            Text(text = "Volver al inicio de sesión")
        }
    }
}