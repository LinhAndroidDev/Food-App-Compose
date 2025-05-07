package com.example.firstjetpackcompose.screen.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpackcompose.screen.common.RadioCommon
import com.example.firstjetpackcompose.screen.map.models.OrderTakingProcessModel
import com.example.firstjetpackcompose.ui.theme.Gray

@Composable
fun OrderTakingProcessView() {
    val list = listOf(
        OrderTakingProcessModel(
            "Order Accepted",
            "06:20 PM",
            true
        ),
        OrderTakingProcessModel(
            "Cooking Food",
            "06:25 PM",
            false
        ),
        OrderTakingProcessModel(
            "Food is being canned",
            "06:40 PM",
            false
        ),
        OrderTakingProcessModel(
            "Shipper is confirming order",
            "06:50 PM",
            false
        ),
        OrderTakingProcessModel(
            "Food's on the Way",
            "07:15 PM",
            false
        ),
        OrderTakingProcessModel(
            "Delivered to you",
            "07:23 PM",
            false
        )
    )

    val orderTakingProgressList = remember { mutableStateOf(list) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(25.dp))
            .padding(horizontal = 15.dp)
    ) {
        itemsIndexed(orderTakingProgressList.value) { index, process ->
            ItemProcess(index, process, orderTakingProgressList.value.size)
        }
    }
}

@Composable
private fun ItemProcess(index: Int, process: OrderTakingProcessModel, size: Int) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    top = if (index == 0) 20.dp else 0.dp,
                    bottom = if (index == size - 1) 40.dp else 0.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioCommon(
                selected = process.isSelected,
                onClick = {},
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = process.title,
                color = if (process.isSelected) Color.Black else Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = process.time,
                color = if (process.isSelected) Color.Black else Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
        }
        Text(
            text = "--------",
            color = Gray,
            fontSize = 10.sp,
            modifier = Modifier
                .padding(start = 15.dp)
                .graphicsLayer {
                    rotationZ = 90f
                    transformOrigin = TransformOrigin.Center
                }
        )
    }
}