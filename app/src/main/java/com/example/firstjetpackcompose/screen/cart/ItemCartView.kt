package com.example.firstjetpackcompose.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.screen.cart.models.CartModel
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun ItemCartView(cartModel: CartModel, onClick: (CartModel) -> Unit, onAdd: (Int) -> Unit, onMinus: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(15.dp)
            .clickable { onClick.invoke(cartModel) }, verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = cartModel.image,
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.size(15.dp))
        Column {
            Text(
                text = cartModel.name,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                lineHeight = 20.sp
            )
            Text(text = cartModel.detail, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.size(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "$${cartModel.price}",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                        .background(color = Green, shape = RoundedCornerShape(5.dp))
                        .padding(2.dp)
                        .clickable {
                            if (cartModel.quantity > 1) {
                                onMinus.invoke(cartModel.quantity - 1)
                            }
                        }
                )
                Text(
                    text = "${cartModel.quantity}",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(25.dp)
                        .background(color = Green, shape = RoundedCornerShape(5.dp))
                        .padding(2.dp)
                        .clickable {
                            onAdd.invoke(cartModel.quantity + 1)
                        }
                )
            }
        }
    }
}