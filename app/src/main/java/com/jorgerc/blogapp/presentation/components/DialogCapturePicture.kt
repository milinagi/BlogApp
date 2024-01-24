package com.jorgerc.blogapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogCapturePicture(
    status: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit,
) {
    if (status.value) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            onDismissRequest = { status.value = false },
            containerColor = Color.White,
            title = {
                Text(
                    text = "Seleccionar una opción",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            },
            text = {
                Column(modifier = Modifier
                    .fillMaxWidth()
                )
                {
                    Row(
                        modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            modifier = Modifier
                                .width(120.dp),
                            onClick = {
                                status.value = false
                                pickImage()
                                }
                        ) {
                            Text(text = "Galería")
                        }
                        Button(
                            modifier = Modifier
                                .width(120.dp),
                            onClick = {
                                status.value = false
                                takePhoto()
                            }
                        ) {
                            Text(text = "Cámara")
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    modifier = Modifier.height(0.dp),
                    onClick = { }
                ) {
                }
            }
        )
    }
}
