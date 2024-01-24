package com.jorgerc.blogapp.presentation.screens.profile_edit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jorgerc.blogapp.R
import com.jorgerc.blogapp.presentation.components.DefaultButton
import com.jorgerc.blogapp.presentation.components.DefaultTextField
import com.jorgerc.blogapp.presentation.components.DialogCapturePicture
import com.jorgerc.blogapp.presentation.screens.profile_edit.ProfileEditViewModel
import com.jorgerc.blogapp.presentation.ui.theme.Red500

@Composable
fun ProfileEditContent(
    navController: NavHostController,
    viewModel: ProfileEditViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val state = viewModel.state
    viewModel.resultingActivityHaldler.handle()

    var dialogState = remember { mutableStateOf(false) }
    DialogCapturePicture(
        status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() }
    )

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
                    if (viewModel.state.image != "") {
                        AsyncImage(
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                                .clickable {
                                           dialogState.value = true
                                },
                            contentScale = ContentScale.Crop,
                            model = viewModel.state.image,
                            contentDescription = "Selected image"
                        )
                    } else {
                        Image(
                            modifier = Modifier
                                .height(120.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "Imagen de usuario"
                        )
                    }
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
                        text = "EDITAR",
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
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 40.dp),
                        text = "ACTUALIZAR DATOS",
                        onClick = { viewModel.saveImage()
                                    viewModel.onUpdate(url = "") },
                    )
                }

            }
        }
    }
}
