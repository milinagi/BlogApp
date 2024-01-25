package com.jorgerc.blogapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material3.Icon
import com.jorgerc.blogapp.presentation.navigation.HomeBottomBarNavGraph
import com.jorgerc.blogapp.presentation.navigation.HomeBottomBarScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        HomeBottomBarNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        HomeBottomBarScreen.Posts,
        HomeBottomBarScreen.MyPosts,
        HomeBottomBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any{ it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: HomeBottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val color = if (selected) LocalContentColor.current else LocalContentColor.current.copy(alpha = 0.4f)

    NavigationBarItem(
        selected = selected,
        onClick = {
                  navController.navigate(screen.route) {
                      popUpTo(navController.graph.findStartDestination().id)
                      launchSingleTop = true
                  }
        },
        icon = {
               Icon(
                   imageVector = screen.icon,
                   contentDescription = "Navigation icon",
                   tint = color
               )
        },
        label = {
            Text(text = screen.title, color = color)
        }
    )
}
