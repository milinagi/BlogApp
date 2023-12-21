package com.jorgerc.blogapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgerc.blogapp.presentation.ui.theme.Red700

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Column {
        Button(
            modifier = modifier,
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(Color(0xFFff7961)),
            enabled = enabled
        ) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 5.dp),
            text = "",
            fontSize = 11.sp,
            color = Red700
        )
    }
}