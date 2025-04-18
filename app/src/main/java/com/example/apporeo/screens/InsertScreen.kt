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
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Calendar
import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


val dbs  = Firebase.firestore

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
        var fechaVencimiento by remember { mutableStateOf(TextFieldValue("")) }
        //var openDatePicker by remember { mutableStateOf(false) }

        /*val context = LocalContext.current
        val calendar = remember { Calendar.getInstance() }*/

        Text(modifier = Modifier.fillMaxWidth(), text = "Registro de nuevo producto", style = TextStyle(fontSize = 18.sp), textAlign = TextAlign.Center)
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
            label = { Text("dd/MM/yyyy") },
            value = fechaVencimiento,
            onValueChange = { newValue ->
                val digits = newValue.text.filter { it.isDigit() }

                val formatted = buildString {
                    for (i in digits.indices) {
                        append(digits[i])
                        if ((i == 1 || i == 3) && i != digits.lastIndex) append('/')
                    }
                }

                // Calculamos nueva posición del cursor
                val newCursorPos = if (fechaVencimiento.text.length < formatted.length) {
                    newValue.selection.end + 1 // Añadimos una barra
                } else {
                    newValue.selection.end
                }.coerceAtMost(formatted.length)

                fechaVencimiento = TextFieldValue(
                    text = formatted,
                    selection = TextRange(newCursorPos)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


            /*readOnly = true,
            trailingIcon = {
                Button(onClick = {openDatePicker = true}) {
                    Text("selecionar")
                }
            }*/
        )

        /*if (openDatePicker) {
            DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    val formattedDate = "$dayOfMonth/${month + 1}/$year"
                    fechaVencimiento = formattedDate
                    openDatePicker = false
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }*/

        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Button(onClick = {abriComposable = true}){
            Text(text = "Registrar")
        }
        if (abriComposable) {
            abriComposable = false
            GuardarEnBD(codigo, nombreProducto, descripcion, cantidad, fechaVencimiento.text)
            codigo = ""
            nombreProducto = ""
            descripcion = ""
            cantidad = ""
            fechaVencimiento = TextFieldValue("")
        }
    }
}

@Composable
fun GuardarEnBD(codigo:String, nombreProducto:String, descripcion:String, cantidad:String, fechaVencimiento:String)
{
    var guardar = remember { mutableStateOf(false) }
    var context = LocalContext.current
    val producto = hashMapOf(
        "codigo" to codigo,
        "nombreProducto" to nombreProducto,
        "descripcion" to descripcion,
        "cantidad" to cantidad.toInt(),
        "fechaVencimiento" to fechaVencimiento
    )
    dbs.collection("Productos")
        .add(producto)
        .addOnSuccessListener {
            Toast.makeText(context, "Producto registrado correctamente", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener {
            Toast.makeText(context, "Error al registrar el producto", Toast.LENGTH_SHORT).show()
        }
}
