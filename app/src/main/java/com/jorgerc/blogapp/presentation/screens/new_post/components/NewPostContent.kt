package com.jorgerc.blogapp.presentation.screens.new_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgerc.blogapp.R
import com.jorgerc.blogapp.presentation.components.DefaultTextField
import com.jorgerc.blogapp.presentation.ui.theme.Red500

data class CategoryRadioButton(
    var category: String,
    var image: Int
)

@Composable
fun NewPostContent() {

    val radioOptions = listOf(
        CategoryRadioButton("PC", R.drawable.icon_pc),
        CategoryRadioButton("PS5", R.drawable.icon_ps4),
        CategoryRadioButton("XBOX", R.drawable.icon_xbox),
        CategoryRadioButton("SWITCH", R.drawable.icon_nintendo),
        CategoryRadioButton("MOBILE", R.drawable.icon_pc),
    )


    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Red500)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .height(130.dp)
                            .padding(top = 20.dp),
                        painter = painterResource(id = R.drawable.add_image),
                        contentDescription = ""
                    )
                    Text(
                        text = "SELECCIONA UNA IMAGEN",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        DefaultTextField(
            modifier = Modifier
                .padding(top = 25.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = {  },
            label = "Nombre del Post",
            icon = Icons.Default.Face,
            errorMsg = "",
            validateField = {

            }
        )
        DefaultTextField(
            modifier = Modifier
                .padding(top = 0.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = {  },
            label = "Descripción",
            icon = Icons.AutoMirrored.Filled.List,
            errorMsg = "",
            validateField = {

            }
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "CATEGORIAS",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        radioOptions.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .selectable(
                        selected = false,
                        onClick = { }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = false,
                    onClick = {  }
                )
                Row {
                    Text(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(12.dp),
                        text = it.category
                    )
                    Image(
                        modifier = Modifier.height(50.dp)
                            .padding(8.dp),
                        painter = painterResource(id = it.image),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}
