package com.jorgerc.blogapp.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jorgerc.blogapp.domain.model.Response
import com.jorgerc.blogapp.presentation.components.ProgressBar
import com.jorgerc.blogapp.presentation.navigation.Graph
import com.jorgerc.blogapp.presentation.screens.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    when(val loginResponse = viewModel.loginResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = Graph.HOME) {
                    popUpTo(Graph.AUTHENTICATION) { inclusive = true }
                }
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, loginResponse.exception?.message?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }
}
