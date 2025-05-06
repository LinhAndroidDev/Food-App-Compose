package com.example.firstjetpackcompose.screen.detail_food

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.IconTop
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.Gray
import com.example.firstjetpackcompose.ui.theme.Green
import com.example.firstjetpackcompose.viewmodel.ShareViewModel

@Composable
fun DetailFoodScreen(navController: NavController, shareViewModel: ShareViewModel) {
    val foodDetail = shareViewModel.selectedFood.value
    val sizeFood = remember { mutableStateOf(SizeFood.SMALL) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackGroundCommon)
    ) {
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 50.dp)) {
            IconTop(image = Icons.Filled.ArrowBack, onClick = { navController.popBackStack() })
            Spacer(modifier = Modifier.weight(1f))
            IconTop(image = Icons.Outlined.FavoriteBorder, onClick = {})
            Spacer(modifier = Modifier.size(10.dp))
            IconTop(image = Icons.Outlined.Share, onClick = {})
        }
        Spacer(modifier = Modifier.size(10.dp))
        foodDetail?.let {
            AsyncImage(
                model = it.image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.size(15.dp))
        Text(
            text = foodDetail?.name ?: "",
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Row(
            modifier = Modifier.padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "${foodDetail?.detail}", fontSize = 12.sp, color = Color.Gray)
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
            Text(text = "(2.2k) ", fontSize = 12.sp, color = Color.Gray)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                modifier = Modifier.size(17.dp),
                contentDescription = "",
                tint = Color.Gray
            )
        }

        SelectSizeFood(typeSize = sizeFood.value, onClick = {
            sizeFood.value = it
        })
    }
}