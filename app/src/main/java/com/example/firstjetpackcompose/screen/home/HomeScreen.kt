package com.example.firstjetpackcompose.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.screen.home.models.FoodModel
import com.example.firstjetpackcompose.IconTop
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.screen.home.models.SellerModel
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.FirstJetpackComposeTheme
import com.example.firstjetpackcompose.ui.theme.Green
import com.example.firstjetpackcompose.viewmodel.ShareViewModel

@Composable
fun HomeScreen(navController: NavController, shareViewModel: ShareViewModel) {
    val items = listOf(
        FoodModel(R.drawable.ic_meat, "Meat"),
        FoodModel(R.drawable.ic_fast_food, "Fast Food"),
        FoodModel(R.drawable.ic_sushi, "Sushi"),
        FoodModel(R.drawable.ic_drink, "drink")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackGroundCommon)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 50.dp)) {
            Column {
                Text(text = "Hello \uD83D\uDC4B", color = Color.Gray)
                Text(text = "Delisas Agency", color = Color.Black, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconTop(image = Icons.Default.Search, onClick = {})
            Spacer(modifier = Modifier.size(10.dp))
            IconTop(image = Icons.Outlined.Notifications, onClick = {})
        }
        LazyRow(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            itemsIndexed(items) { index, item ->
                ItemFoodView(index = index, foodModel = item)
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        Box {
            AsyncImage(
                model = "https://assets.grab.com/wp-content/uploads/sites/11/2019/12/02160118/BlogMega.jpg",
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxWidth()
                    .height(180.dp)
            )

            // Lớp phủ gradient
            Box(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 1f)),
                            startY = 0f,
                            endY = 900f
                        )
                    )
                    .align(Alignment.BottomCenter)
            )

            Text(
                text = "Get Now",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 30.dp, bottom = 10.dp)
                    .background(color = Green, shape = RoundedCornerShape(25.dp))
                    .padding(horizontal = 20.dp, vertical = 5.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .align(Alignment.BottomStart)
            )
        }

        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 20.dp)) {
            Text(
                text = "Best Sellers",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "See all", fontSize = 16.sp, color = Green)
        }

        Spacer(modifier = Modifier.size(20.dp))

        ListSeller(navController, shareViewModel)
    }
}

@Composable
fun ListSeller(navController: NavController, shareViewModel: ShareViewModel) {
    val sellers = listOf(
        SellerModel(
            name = "Melting Cheese Pizza",
            price = 10.99f,
            image = "https://thepizzacompany.vn/images/thumbs/000/0002214_sf-deluxe_500.png",
            calories = 44,
            time = 16
        ),
        SellerModel(
            name = "Cheese burger",
            price = 4.99f,
            image = "https://willys-kitchen.com/storage/2022/05/Original-Cheese-Burger-New-Small.png",
            calories = 31,
            time = 20
        ),
        SellerModel(
            name = "Fried chicken Jollibee",
            price = 12.99f,
            image = "https://jollibee.com.vn/media/catalog/product/cache/11f3e6435b23ab624dc55c2d3fe9479d/g/_/g_gi_n_vui_v_-_1_1.png",
            calories = 54,
            time = 35
        ),
        SellerModel(
            name = "Shaking beef stew",
            price = 8f,
            image = "https://minhngan.vn/assets/uploads/2022/11/Com-tho-bo-luc-lac-trung-1.png",
            calories = 22,
            time = 60
        ),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(start = 15.dp)
            .height(700.dp),
        userScrollEnabled = false
    ) {
        items(count = sellers.size) { index ->
            ItemSellerView(sellers[index], onClick = {
                shareViewModel.setSelectedFood(sellers[index].convertToDetailFoodModel())
                navController.navigate("detail_food")
            })
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FirstJetpackComposeTheme {
        HomeScreen(
            navController = NavController(context = LocalContext.current),
            shareViewModel = ShareViewModel()
        )
    }
}