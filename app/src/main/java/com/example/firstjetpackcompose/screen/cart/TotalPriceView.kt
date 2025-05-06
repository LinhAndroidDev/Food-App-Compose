package com.example.firstjetpackcompose.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun TotalPriceView(total: Float, delivery: Float) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 15.dp)) {
            Text(text = "Subtotal", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$$total",
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = Color.Black
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = BackGroundCommon)
        )
        Row(modifier = Modifier.padding(vertical = 15.dp)) {
            Text(text = "Delivery", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$5",
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = Color.Black
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = BackGroundCommon)
        )
        Row(modifier = Modifier.padding(vertical = 15.dp)) {
            Text(
                text = "Total",
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$${total + delivery}", fontSize = 16.sp, fontWeight = FontWeight.W500, color = Green)
        }

    }
}