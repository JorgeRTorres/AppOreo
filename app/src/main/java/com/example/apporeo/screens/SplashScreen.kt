package com.example.apporeo.screens

import android.content.Context
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apporeo.navigation.AppScreens
import com.example.apporeo.R
import android.content.SharedPreferences
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var isVisible by remember { mutableStateOf(false) }
    var backgroundColor by remember { mutableStateOf(Color(0xFF00CDD7)) }

    val animatedBackground by animateColorAsState(
        targetValue = backgroundColor,
        animationSpec = tween(durationMillis = 4000)
    )

    val context = LocalContext.current
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("mis_prefs", Context.MODE_PRIVATE)

    LaunchedEffect(Unit) {
        isVisible = true
        delay(3000)
        backgroundColor = Color(0xFF00CDD7)
        delay(3000)

        // Verificar si las credenciales están disponibles
        val userCredentials = sharedPreferences.getString("user_credentials", null)

        if (userCredentials != null) {
            // Si las credenciales existen, navegar a HomeScreen
            navController.navigate(AppScreens.HomeScreen.route) {
                popUpTo(AppScreens.SplashScreen.route) { inclusive = true }
            }
        } else {
            // Si no hay credenciales, navegar al LoginScreen
            navController.navigate(AppScreens.LoginScreen.route) {
                popUpTo(AppScreens.SplashScreen.route) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(animatedBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.huella2),
            contentDescription = "Huella",
            modifier = Modifier
                .size(150.dp)
                .offset(x = (-100).dp, y = (-300).dp)
        )
        Image(
            painter = painterResource(R.drawable.huella2),
            contentDescription = "Huella",
            modifier = Modifier
                .size(170.dp)
                .offset(x = (50).dp, y = (300).dp)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(1000)) + scaleIn(initialScale = 0.8f)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(1200))
            ) {
                Text(
                    text = "Bienvenido a Oreo",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
