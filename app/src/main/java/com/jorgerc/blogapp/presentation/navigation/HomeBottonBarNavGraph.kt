package com.jorgerc.blogapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jorgerc.blogapp.presentation.screens.my_posts.MyPostsScreen
import com.jorgerc.blogapp.presentation.screens.posts.PostsScreen
import com.jorgerc.blogapp.presentation.screens.profile.ProfileScreen


@Composable
fun HomeBottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ) {

        composable(route = HomeBottomBarScreen.Posts.route) {
            PostsScreen(navController)
        }

        composable(route = HomeBottomBarScreen.MyPosts.route) {
            MyPostsScreen(navController)
        }

        composable(route = HomeBottomBarScreen.Profile.route) {
            ProfileScreen(navController)
        }

        detailsNavGraph(navController)

    }

}


sealed class HomeBottomBarScreen(
    val route: String,
    var title: String,
    val icon: ImageVector
) {

    object Posts: HomeBottomBarScreen(
        route = "posts",
        title = "Posts",
        icon = Icons.AutoMirrored.Filled.List
    )

    object MyPosts: HomeBottomBarScreen(
        route = "my_posts",
        title = "Mis Posts",
        icon = Icons.AutoMirrored.Outlined.List
    )

    object Profile: HomeBottomBarScreen(
        route = "profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}
