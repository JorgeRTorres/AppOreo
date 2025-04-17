package com.example.apporeo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

//val db = Firebase.firestore

@Composable
fun InsertScreen(navController: NavController)
{
    Body()
}

@Composable
fun Body()
{
    Column(modifier = Modifier.fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        InsertData()
    }
}

@Composable
fun InsertData(){
    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
       //Variables de modelo
        var abriComposable by remember { mutableStateOf(false) }
        var codigo by remember { mutableStateOf("") }
        var nombreProducto by remember { mutableStateOf("") }
        var descripcion by remember { mutableStateOf("") }
        var cantidad by remember { mutableStateOf("") }
        var fechaVencimiento by remember { mutableStateOf("") }

        Text(modifier = Modifier.size(18.dp).fillMaxWidth(), text = "Registro de nuevo producto")
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        OutlinedTextField(
            singleLine = true,
            label = { Text(text = "Ingrese codigo de producto") },
            value = codigo,
            onValueChange = { codigo = it }
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        OutlinedTextField(
            singleLine = true,
            label = { Text(text = "Ingrese nombre de producto") },
            value = nombreProducto,
            onValueChange = { nombreProducto = it }
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        OutlinedTextField(
            singleLine = true,
            label = { Text(text = "Ingrese la presentacion") },
            value = descripcion,
            onValueChange = { descripcion = it }
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        OutlinedTextField(
            singleLine = true,
            label = { Text(text = "Ingrese la cantidad") },
            value = cantidad,
            onValueChange = { cantidad = it }
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        OutlinedTextField(
            singleLine = true,
            label = { Text(text = "Ingrese fecha de vencimiento") },
            value = fechaVencimiento,
            onValueChange = { fechaVencimiento = it }
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Button(onClick = {abriComposable = true})
        {
            /*if (abriComposable) {
                abriComposable = false
                GuardarEnBD(codigo, nombreProducto, descripcion, cantidad, fechaVencimiento)
                codigo = ""
                nombreProducto = ""
                descripcion = ""
                cantidad = ""
                fechaVencimiento = ""
            }*/
        }
    }
}