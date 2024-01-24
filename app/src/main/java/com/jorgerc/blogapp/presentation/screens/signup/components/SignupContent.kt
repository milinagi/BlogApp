package com.jorgerc.blogapp.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jorgerc.blogapp.R
import com.jorgerc.blogapp.presentation.components.DefaultButton
import com.jorgerc.blogapp.presentation.components.DefaultTextField
import com.jorgerc.blogapp.presentation.screens.signup.SignupViewModel
import com.jorgerc.blogapp.presentation.ui.theme.Red500

@Composable
fun SignupContent(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {

    val scrollState = rememberScrollState()
    val state = viewModel.state

    Column(modifier = Modifier.verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
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
                                top = 10.dp,
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
                        modifier = Modifier.padding(top = 15.dp),
                        value = state.username,
                        onValueChange = { viewModel.onUserNameInput(it) },
                        label = "Nombre de usuario",
                        icon = Icons.Default.Person,
                        errorMsg = viewModel.usernameErrMsg,
                        validateField = { viewModel.validateUsername() }
                    )
                    DefaultTextField(
                        modifier = Modifier.padding(top = 5.dp),
                        value = state.email,
                        onValueChange = { viewModel.onEmailInput(it) },
                        label = "Correo electronico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email,
                        errorMsg = viewModel.emailErrMsg,
                        validateField = { viewModel.validateEmail() }
                    )
                    DefaultTextField(
                        modifier = Modifier.padding(top = 5.dp),
                        value = state.password,
                        onValueChange = { viewModel.onPasswordInput(it) },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        hideText = true,
                        errorMsg = viewModel.passwordErrMsg,
                        validateField = { viewModel.validatePassword() }
                    )
                    DefaultTextField(
                        modifier = Modifier.padding(top = 5.dp),
                        value = state.confirmPassword,
                        onValueChange = { viewModel.onConfirmPasswordInput(it) },
                        label = "Confirmar Contraseña",
                        icon = Icons.Outlined.Lock,
                        hideText = true,
                        errorMsg = viewModel.confirmPasswordErrMsg,
                        validateField = { viewModel.validateConfirmPassword() }
                    )

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        text = "REGISTRARSE",
                        onClick = {
                            viewModel.onSignup()
                        },
                        enabled = viewModel.isEnabledSignupButton
                    )

                }

            }
        }
    }
}
