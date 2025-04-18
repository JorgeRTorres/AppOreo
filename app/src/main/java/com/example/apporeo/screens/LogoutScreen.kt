package com.example.apporeo.screens

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.apporeo.navigation.AppScreens

@Composable
fun LogoutDialogScreen(
    navController: NavController,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Cerrar sesión") },
        text = { Text("¿Estás seguro que deseas cerrar sesión?") },
        confirmButton = {
            TextButton(onClick = {
                // 1. Borrar preferencias (si las usas)
                context.getSharedPreferences("mis_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .clear()
                    .apply()

                navController.navigate(AppScreens.LoginScreen.route) {
                    // Asegúrate de limpiar correctamente la pila de navegación
                    popUpTo(AppScreens.SplashScreen.route) { inclusive = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }) {
                Text("Sí")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}
