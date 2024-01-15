package com.jorgerc.blogapp.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jorgerc.blogapp.R
import com.jorgerc.blogapp.presentation.components.DefaultButton
import com.jorgerc.blogapp.presentation.navigation.AppScreen
import com.jorgerc.blogapp.presentation.screens.profile.ProfileViewModule

@Composable
fun ProfileContent(navController: NavHostController, viewModel: ProfileViewModule = hiltViewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box()
        {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Bienvenido",
                    fontSize = 30.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(55.dp))
                Image(
                    modifier = Modifier
                        .size(115.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = ""
                )
            }
        }
        
        Spacer(modifier = Modifier.height(55.dp))
        Text(
            text = viewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = viewModel.userData.email,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            modifier = Modifier
                .width(250.dp),
            text = "Editar datos",
            color = Color.White,
            icon = Icons.Default.Edit,
            onClick = {  }
        )
        DefaultButton(
            modifier = Modifier
                .width(250.dp),
            text = "Cerrar sesion",
            onClick = {
                viewModel.logout()
                navController.navigate(route = AppScreen.Login.route) {
                    popUpTo(AppScreen.Profile.route) { inclusive = true }
                }
            }
        )
    }
}