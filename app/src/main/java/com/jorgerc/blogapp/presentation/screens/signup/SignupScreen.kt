package com.jorgerc.blogapp.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jorgerc.blogapp.presentation.components.DefaultTopBar
import com.jorgerc.blogapp.presentation.screens.signup.components.SignUp
import com.jorgerc.blogapp.presentation.screens.signup.components.SignupContent


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignupScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "Nuevo usuario",
                     upAvailable = true,
                     navController = navController
                 )
        },
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                SignupContent(navController)
            }
        },
        bottomBar = {}
    )
    SignUp(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}