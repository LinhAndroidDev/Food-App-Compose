package com.example.firstjetpackcompose.screen.detail_food

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpackcompose.ui.theme.Gray
import com.example.firstjetpackcompose.ui.theme.Green

enum class SizeFood(val size: String, val price: Float) {
    SMALL("6' - Small", 8.99f),
    MEDIUM("8' - Medium", 10.99f),
    LARGE("10' - Large", 12.99f)
}

@Composable
fun SelectSizeFood(
    typeSize: SizeFood,
    onClick: (SizeFood) -> Unit
) {
    Row(modifier = Modifier.padding(top = 30.dp).fillMaxWidth()) {
        Spacer(modifier = Modifier.size(15.dp))
        Column(modifier = Modifier.weight(1f)) {
            ItemSizeFoodView(
                selected = typeSize == SizeFood.SMALL,
                typeSize = SizeFood.SMALL,
                onClick = { onClick(SizeFood.SMALL) }
            )
        }
        Spacer(modifier = Modifier.size(15.dp))
        Column(modifier = Modifier.weight(1f)) {
            ItemSizeFoodView(
                selected = typeSize == SizeFood.MEDIUM,
                typeSize = SizeFood.MEDIUM,
                onClick = { onClick(SizeFood.MEDIUM) }
            )
        }
        Spacer(modifier = Modifier.size(15.dp))
        Column(modifier = Modifier.weight(1f)) {
            ItemSizeFoodView(
                selected = typeSize == SizeFood.LARGE,
                typeSize = SizeFood.LARGE,
                onClick = { onClick(SizeFood.LARGE) }
            )
        }
        Spacer(modifier = Modifier.size(15.dp))
    }
}

@Composable
fun ItemSizeFoodView(selected: Boolean = false, typeSize: SizeFood, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            .border(width = 1.dp, color = if (selected) Green else Color.White, shape = RoundedCornerShape(15.dp))
            .clickable { onClick.invoke() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RadioButton(
            selected = selected,
            onClick = { onClick.invoke() },
            colors = RadioButtonDefaults.colors(
                selectedColor = Green,
                unselectedColor = Gray,
            )
        )
        Text(text = typeSize.size, fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(5.dp))
        Text(
            text = "${typeSize.price}",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.W500
        )
        Spacer(modifier = Modifier.size(15.dp))
    }
}