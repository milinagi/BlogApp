package com.jorgerc.blogapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.jorgerc.blogapp.presentation.screens.profile_edit.ProfileEditScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {

        composable(
            route = DetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navController, user = it)
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {

    object ProfileUpdate: DetailsScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }
}
