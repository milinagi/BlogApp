package com.jorgerc.blogapp.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgerc.blogapp.R
import com.jorgerc.blogapp.presentation.components.DefaultButton
import com.jorgerc.blogapp.presentation.components.DefaultTextField
import com.jorgerc.blogapp.presentation.screens.login.LoginViewModel
import com.jorgerc.blogapp.presentation.ui.theme.BlogAppTheme
import com.jorgerc.blogapp.presentation.ui.theme.Red500

@Composable
fun LoginContent(viewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .padding()
            .fillMaxWidth(),
    ) {
        BoxHeader()
        CardForm(viewModel)
    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Red500)
    ) {
        Column(
            modifier = Modifier.
                fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(130.dp),
                painter = painterResource(id = R.drawable.control),
                contentDescription = "Control de xbox 360"
            )
            Text(
                text = "Firebase MVVM",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardForm(viewModel: LoginViewModel) {

//    var email by remember {
//        mutableStateOf("")
//    }
//    var password by remember {
//        mutableStateOf("")
//    }

    Card(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 200.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF272727), //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 40.dp),
                text = "LOGIN",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                text = "Por favor inicia sesión para continuar",
                color = Color.Gray,
                fontSize = 16.sp
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it},
                label = "Email",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 8.dp),
                value = viewModel.password.value,
                onValueChange = { viewModel.password.value = it},
                label = "Contraseña",
                icon = Icons.Default.Lock,
                hideText = true
            )
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp),
                text = "INICIAR SESION",
                onClick = { }
            )
        }
    }
}