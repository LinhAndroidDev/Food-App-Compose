package com.example.firstjetpackcompose.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.firstjetpackcompose.screen.home.models.FoodModel

@Composable
fun ItemFoodView(index: Int, foodModel: FoodModel) {
    Column(
        modifier = Modifier
            .padding(start = if (index == 0) 15.dp else 0.dp , end = 15.dp)
            .size(width = 95.dp, height = 100.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = foodModel.image),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Text(
            text = foodModel.name,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}