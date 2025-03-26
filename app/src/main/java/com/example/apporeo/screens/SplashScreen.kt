package com.example.apporeo.screens
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.apporeo.navigation.AppScreens
import com.example.apporeo.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController)
{//Pantalla de bienvenida al abrir la app
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreens.LoginScreen.route)
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(R.drawable.logo),
            contentDescription = "")
        Text(text = "OREO")
    }
}