package com.jorgerc.blogapp.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jorgerc.blogapp.presentation.screens.login.components.Login
import com.jorgerc.blogapp.presentation.screens.login.components.LoginBottomBar
import com.jorgerc.blogapp.presentation.screens.login.components.LoginContent
import com.jorgerc.blogapp.presentation.ui.theme.BlogAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {


    Scaffold(
        topBar = { },
        content = {
                  LoginContent(navController)
        },
        bottomBar = {
            LoginBottomBar(navController)
        }
    )
    //Maneja el estado de la peticion de login
    Login(navController = navController)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    BlogAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}