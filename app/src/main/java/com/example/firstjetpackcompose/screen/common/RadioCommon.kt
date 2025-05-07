package com.example.firstjetpackcompose.screen.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.ui.theme.Gray
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun RadioCommon(selected: Boolean = false, onClick: () -> Unit) {
    Icon(
        painter = painterResource(id = if (selected) R.drawable.ic_checked_radio else R.drawable.ic_un_checked_radio),
        tint = if (selected) Green else Gray,
        modifier = Modifier
            .size(25.dp)
            .clip(CircleShape)
            .clickable {
                onClick.invoke()
            },
        contentDescription = ""
    )
}