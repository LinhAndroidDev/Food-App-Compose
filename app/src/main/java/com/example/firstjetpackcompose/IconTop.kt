package com.example.firstjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconTop(image: ImageVector, onClick: () -> Unit) {
    Icon(
        imageVector = image,
        contentDescription = "",
        tint = Color.Gray,
        modifier = Modifier
            .size(45.dp)
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .padding(10.dp)
            .clickable { onClick.invoke() },
    )
}