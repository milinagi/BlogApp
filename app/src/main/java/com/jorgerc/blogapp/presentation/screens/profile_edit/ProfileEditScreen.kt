package com.jorgerc.blogapp.presentation.screens.profile_edit

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jorgerc.blogapp.presentation.components.DefaultTopBar
import com.jorgerc.blogapp.presentation.screens.profile_edit.components.ProfileEditContent
import com.jorgerc.blogapp.presentation.screens.profile_edit.components.Update

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    user: String
) {

    Log.d("ProfileEditScreen", "Usuario: $user")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                ProfileEditContent(navController)
            }
        },
        bottomBar = {}
    )
    Update()
}