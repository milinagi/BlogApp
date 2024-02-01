package com.jorgerc.blogapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jorgerc.blogapp.presentation.screens.login.LoginScreen
import com.jorgerc.blogapp.presentation.screens.signup.SignupScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {

        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(route = AuthScreen.Signup.route) {
            SignupScreen(navController)
        }

    }
}

sealed class AuthScreen(val route: String) {

    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")

}
