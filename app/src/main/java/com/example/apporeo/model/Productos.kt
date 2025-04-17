package com.example.apporeo.model

import java.util.Date

data class Productos(

    val codigo: String,
    val nombreProducto: String,
    val descripcion: String,
    val cantidad: Int,
    val fechaVencimiento: Date

)
