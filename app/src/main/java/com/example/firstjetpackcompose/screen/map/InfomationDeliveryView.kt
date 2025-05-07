package com.example.firstjetpackcompose.screen.map

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.Gray
import com.example.firstjetpackcompose.ui.theme.Green

@Composable
fun InformationDeliveryView() {
    val currentProgress = remember { mutableFloatStateOf(0.6f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Green,
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                CircularProgressIndicator(
                    progress = { currentProgress.value },
                    modifier = Modifier
                        .size(70.dp),
                    strokeWidth = 3.dp,
                    color = Color(0xFFFFCE3B),
                    trackColor = Gray
                )
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${(currentProgress.value * 100).toInt()}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.White
                    )
                    Text(text = "min", fontSize = 12.sp, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.size(15.dp))
            Column {
                Text(
                    text = "Delivery",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "The courier is on the way",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                model = "https://image.optcdn.me/9939220b051fa10458884f6465879360-icon-giao-hang.png",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.size(80.dp),
                contentDescription = ""
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = BackGroundCommon,
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "https://www.frontier-economics.com.au/wp-content/uploads/2023/10/22.png",
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color.Black,
                            shape = CircleShape
                        )
                        .clip(
                            CircleShape
                        ),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.size(15.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "John Smith",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.Black
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Driver", fontSize = 12.sp, color = Color.Gray)
                        Text(text = "  •  ", fontSize = 16.sp, color = Gray)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            modifier = Modifier.size(18.dp),
                            contentDescription = null,
                            tint = Green
                        )
                        Text(
                            text = " 4.8 ",
                            fontSize = 12.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W500
                        )
                    }
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_message),
                    contentDescription = "",
                    tint = Green,
                    modifier = Modifier
                        .border(1.dp, color = Green, shape = CircleShape)
                        .clip(CircleShape)
                        .padding(10.dp)
                        .size(25.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_call),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 15.dp, end = 5.dp)
                        .background(
                            color = Green,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                        .padding(10.dp)
                        .size(25.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                OrderTakingProcessView()
            }
        }
    }
}