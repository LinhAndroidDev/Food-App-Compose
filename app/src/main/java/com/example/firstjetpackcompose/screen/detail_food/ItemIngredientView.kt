package com.example.firstjetpackcompose.screen.detail_food

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.screen.detail_food.models.IngredientModel
import com.example.firstjetpackcompose.ui.theme.Gray
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun ItemIngredientView(ingredientModel: IngredientModel, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            .padding(15.dp)
            .clickable {
                onCheckedChange.invoke(!ingredientModel.isSelected)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ingredientModel.image,
            modifier = Modifier.size(50.dp),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(15.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = ingredientModel.name,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500
            )
            Spacer(modifier = Modifier.size(5.dp))
            Row {
                Text(text = "${ingredientModel.quantity} gm", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "+$${ingredientModel.price}",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500
                )
            }
        }
        Checkbox(
            checked = ingredientModel.isSelected,
            onCheckedChange = { onCheckedChange.invoke(!ingredientModel.isSelected) },
            colors = CheckboxDefaults.colors(
                checkedColor = Green,
                uncheckedColor = Gray,
                checkmarkColor = Color.White
            )
        )
    }
}