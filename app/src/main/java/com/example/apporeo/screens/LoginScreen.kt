package com.example.apporeo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apporeo.navigation.AppScreens
import androidx.compose.ui.res.painterResource
import com.example.apporeo.R

@Composable
fun LoginScreen(navController: NavController){
    var usuario = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var errorUsuario = remember { mutableStateOf(false) }
    var errorPassword = remember { mutableStateOf(false) }
    var errorLogin = remember { mutableStateOf(false) }  // Error para credenciales incorrectas

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00CDD7)), // Fondo cubre toda la pantalla
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.huella2), // Imagen de huella
            contentDescription = "Huella",
            modifier = Modifier
                .size(150.dp)
                .offset(x = (-100).dp, y = (-300).dp) // Posición superior izquierda
        )
        Image(
            painter = painterResource(R.drawable.huella2),
            contentDescription = "Huella",
            modifier = Modifier
                .size(170.dp)
                .offset(x = (50).dp, y = (300).dp) // Posición inferior derecha
        )


        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Image(painter = painterResource(R.drawable.logo), contentDescription = "" )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                value = usuario.value,
                onValueChange = {usuario.value = it
                    errorUsuario.value = it.isEmpty()},
                singleLine = true,
                isError = errorUsuario.value,
                label = { Text("Ingresa tu usuario") },
                trailingIcon = {
                    if (errorUsuario.value){
                        Icon(Icons.Filled.Warning, contentDescription = "Error", tint = Color.Red)
                    }
                })

            if (errorUsuario.value){
                Text(color = Color.Red, text = "No deje usuario vacio")
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            //caja de texto de password
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                value = password.value,
                onValueChange = {password.value = it
                    errorPassword.value = it.isEmpty()},
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                isError = errorPassword.value,
                label = { Text("Ingresa tu contraseña") },
                trailingIcon = {
                    if (errorPassword.value){
                        Icon(Icons.Filled.Warning, contentDescription = "Error", tint = Color.Red)
                    }
                })
            if (errorPassword.value){
                Text(color = Color.Red, text = "No deje password vacio")
            }

            // Mostrar error de credenciales incorrectas
            if (errorLogin.value) {
                Text(color = Color.Red, text = "Usuario o contraseña incorrectos.")
            }

            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Button(onClick = {

                    // Validar campos vacíos
                    if (usuario.value.isEmpty())
                        errorUsuario.value = true
                    else
                        errorUsuario.value = false

                    if (password.value.isEmpty())
                        errorPassword.value = true
                    else
                        errorPassword.value = false

                    // Verificar las credenciales
                    if (!errorUsuario.value && !errorPassword.value) {
                        if (usuario.value == "admin" && password.value == "admin123") {
                            // Si las credenciales son correctas
                            navController.navigate(AppScreens.HomeScreen.route) {
                                // Evita retroceder al login una vez logeado
                                popUpTo(AppScreens.LoginScreen.route) { inclusive = true }
                            }
                        } else {
                            // Si las credenciales son incorrectas
                            errorLogin.value = true
                        }
                    }

                }, modifier = Modifier.width(220.dp)) {
                    Text(text = "Iniciar Sesion")
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            TextButton (onClick = {navController.navigate(AppScreens.PassRecoverScreen.route)}){
                Text(text = "Olvide mi contraseña")
            }
        }
    }
}
