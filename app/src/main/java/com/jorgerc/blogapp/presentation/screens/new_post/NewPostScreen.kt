package com.jorgerc.blogapp.presentation.screens.new_post



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jorgerc.blogapp.presentation.components.DefaultButton
import com.jorgerc.blogapp.presentation.components.DefaultTopBar
import com.jorgerc.blogapp.presentation.screens.new_post.components.NewPostContent


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPostScreen(navController: NavHostController) {

    Scaffold (
        topBar = {
                 DefaultTopBar(
                     title = "Nuevo Post",
                     upAvailable = true,
                     navController = navController
                 )
        },
        content =  {
            NewPostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "PUBLICAR",
                onClick = {  }
            )
        }
    )
}
