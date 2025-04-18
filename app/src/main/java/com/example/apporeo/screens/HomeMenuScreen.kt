package com.example.apporeo.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apporeo.model.Productos
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

val db = Firebase.firestore

@Composable
fun HomeMenuScreen(navController: NavController) {
    var productos by remember { mutableStateOf<List<Productos>>(emptyList()) }
    var cargando by remember { mutableStateOf(true) }

    // Cargar productos desde Firebase
    LaunchedEffect(true) {
        cargando = true
        db.collection("Productos")
            .get()
            .addOnSuccessListener { result ->
                val listaProductos = mutableListOf<Productos>()
                for (document in result) {
                    val codigo = document.getString("codigo") ?: ""
                    val nombreProducto = document.getString("nombreProducto") ?: ""
                    val descripcion = document.getString("descripcion") ?: ""
                    val cantidad = document.getLong("cantidad")?.toInt() ?: 0

                    val fechaVencimiento = try {
                        val timestamp = document.get("fechaVencimiento")
                        when (timestamp) {
                            is Timestamp -> timestamp.toDate()
                            is String -> SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(timestamp)
                            else -> null
                        } ?: Date()
                    } catch (e: Exception) {
                        Log.e("Firestore", "Error al convertir fecha: ${e.message}")
                        Date()
                    }

                    val producto = Productos(codigo, nombreProducto, descripcion, cantidad, fechaVencimiento)
                    listaProductos.add(producto)
                }
                productos = listaProductos
                cargando = false
            }
            .addOnFailureListener { exception ->
                Toast.makeText(navController.context, "Error al cargar productos", Toast.LENGTH_SHORT).show()
                Log.e("Firestore", "Fallo al cargar productos: ${exception.message}")
                cargando = false
            }
    }

    if (cargando) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
                Text(text = "Cargando productos...", modifier = Modifier.padding(top = 8.dp))
            }
        }
    } else {
        ListadoProductos(productos)
    }
}

@Composable
fun ListadoProductos(productos: List<Productos>) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text(
            text = "Listado de Productos",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical =  16.dp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.padding(vertical = 20.dp))


        // Lista de productos
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            items(productos) { producto ->
                ProductoItem(producto)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@Composable
fun ProductoItem(producto: Productos) {
    val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val fechaFormateada = formatoFecha.format(producto.fechaVencimiento)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "Código: ${producto.codigo}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Nombre: ${producto.nombreProducto}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Descripción: ${producto.descripcion}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Cantidad: ${producto.cantidad}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Fecha de Vencimiento: $fechaFormateada", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
