package com.example.firstjetpackcompose.screen.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun PromoCodeView() {
    Row(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 15.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_promo_code),
            contentDescription = "Promo Code",
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Promo Code", fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Apply", fontSize = 16.sp, color = Color.White, modifier = Modifier
                .background(color = Green, shape = RoundedCornerShape(50.dp))
                .padding(horizontal = 20.dp, vertical = 5.dp)
        )
    }
}