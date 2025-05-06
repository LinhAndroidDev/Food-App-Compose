package com.example.firstjetpackcompose.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.screen.home.models.SellerModel
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun ItemSellerView(sellerModel: SellerModel) {
    Column(
        modifier = Modifier
            .padding(end = 15.dp, bottom = 15.dp)
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = sellerModel.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = "$${sellerModel.price}", fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(10.dp))
        AsyncImage(
            model = sellerModel.image,
            contentDescription = "",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "\uD83D\uDD25 ${sellerModel.calories} Calories",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Row(
            modifier = Modifier.align(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "",
                    modifier = Modifier.size(17.dp),
                    tint = Color.Gray,

                )
                Text(text = " ${sellerModel.time} min", fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 5.dp, bottom = 5.dp)
                    .size(25.dp)
                    .background(color = Green, shape = RoundedCornerShape(5.dp))
                    .padding(2.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemSeller() {
    ItemSellerView(
        SellerModel(
            name = "Melting Cheese Pizza",
            price = 10.99f,
            image = "https://example.com/image.jpg",
            calories = 300,
            time = 20
        )
    )
}
