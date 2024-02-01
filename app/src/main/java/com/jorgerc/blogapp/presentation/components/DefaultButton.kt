package com.jorgerc.blogapp.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jorgerc.blogapp.presentation.ui.theme.default

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    color: Color = default,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowForward,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
        Button(
            modifier = modifier,
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(color),
            enabled = enabled
        ) {
            Icon(
                imageVector = icon,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text)
        }
}
