package com.jorgerc.blogapp.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.jorgerc.blogapp.presentation.ui.theme.Red500

@Composable
fun SignupContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        ) {
        BoxHeader()
        CardForm()
    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(Red500),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                modifier = Modifier.height(120.dp),
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Imagen de usuario"
            )
        }

    }
}

@Composable
fun CardForm() {

    var email by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 170.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF272727), //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        )
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        top = 40.dp,
                        bottom = 0.dp,
                        start = 0.dp,
                        end = 0.dp
                    ),
                text = "REGISTRO",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Por favor ingresa estos datos para continuar",
                fontSize = 12.sp,
                color = Color.Gray
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = username,
                onValueChange = { username = it },
                label = "Nombre de usuario",
                icon = Icons.Default.Person,
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = email,
                onValueChange = { email = it },
                label = "Correo electronico",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = password,
                onValueChange = { password = it },
                label = "Contraseña",
                icon = Icons.Default.Lock,
                hideText = true
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirmar Contraseña",
                icon = Icons.Outlined.Lock,
                hideText = true
            )

            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                text = "REGISTRARSE",
                onClick = {  },
            )

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignupContent() {
    SignupContent()
}