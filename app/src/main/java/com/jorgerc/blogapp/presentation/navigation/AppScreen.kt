package com.jorgerc.blogapp.presentation.navigation

sealed class AppScreen(val route: String){

    object Login: AppScreen("login")
    object Signup: AppScreen("signup")
    object Profile: AppScreen("profile")
}
