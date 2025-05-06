package com.example.firstjetpackcompose.screen.detail_food

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.firstjetpackcompose.IconTop
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.screen.detail_food.models.IngredientModel
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.Gray
import com.example.firstjetpackcompose.ui.theme.Green
import com.example.firstjetpackcompose.viewmodel.ShareViewModel

@Composable
fun DetailFoodScreen(navController: NavController, shareViewModel: ShareViewModel) {
    val foodDetail = shareViewModel.selectedFood.value
    val sizeFood = remember { mutableStateOf(SizeFood.SMALL) }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackGroundCommon)
                .verticalScroll(rememberScrollState())
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

            Text(
                text = "Add Ingredients",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp, top = 30.dp, bottom = 20.dp)
            )

            ListIngredient()

            Spacer(modifier = Modifier.size(120.dp))
        }
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Row(modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(50.dp))
                .border(width = 1.dp, color = Green, shape = RoundedCornerShape(50.dp))
                .padding(horizontal = 20.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Outlined.Delete, tint = Gray, modifier = Modifier.size(23.dp), contentDescription = "")
                Text(text = "1", fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.W500, modifier = Modifier.padding(horizontal = 10.dp))
                Icon(imageVector = Icons.Outlined.Add, tint = Green, modifier = Modifier.size(20.dp), contentDescription = "")
            }
            Text(
                "Add to Cart • $${foodDetail?.price}",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(color = Green, shape = RoundedCornerShape(50.dp))
                    .weight(1f)
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun ListIngredient() {
    val ingredientList = listOf(
        IngredientModel(
            name = "Chicken",
            image = "https://a.fsimg.co.nz/product/retail/fan/image/400x400/5256390.png",
            quantity = 350,
            price = 5.99f
        ),
        IngredientModel(
            name = "Onion",
            image = "https://static.vecteezy.com/system/resources/previews/046/439/096/non_2x/onion-isolated-on-a-transparent-background-png.png",
            quantity = 110,
            price = 0.89f
        ),
        IngredientModel(
            name = "Garlic",
            image = "https://dtgxwmigmg3gc.cloudfront.net/imagery/assets/derivations/icon/512/512/true/eyJpZCI6IjczOWI2MzFmMzAxM2UyOTA4OTIxZWIxYjNlMWE2NGRjIiwic3RvcmFnZSI6InB1YmxpY19zdG9yZSJ9?signature=362b959e53230b8c1600d63baea2540fa9cd37a354701f9358bb92cc0898e91e",
            quantity = 50,
            price = 0.49f
        ),
        IngredientModel(
            name = "Tomato",
            image = "https://cdn.pixabay.com/photo/2021/10/14/03/19/tomato-6707992_1280.png",
            quantity = 120,
            price = 1.29f
        ),
        IngredientModel(
            name = "Carrot",
            image = "https://www.bordbia.ie/globalassets/bordbia2020/food-and-living/best-in-season-2020/veg/carrot.png",
            quantity = 100,
            price = 0.79f
        ),
        IngredientModel(
            name = "Potato",
            image = "https://www.bigbasket.com/media/uploads/p/xxl/40048457-4_3-fresho-potato-new-crop.jpg",
            quantity = 230,
            price = 1.19f
        )
    )

    val list = remember { mutableStateOf(ingredientList) }

    Column {
        list.value.forEachIndexed { index, ingredient ->
            ItemIngredientView(ingredientModel = ingredient) { isChecked ->
                Log.e("ItemIngredientView", "isChecked: $isChecked")
                list.value = list.value.toMutableList().apply {
                    this[index] = this[index].copy(isSelected = isChecked)
                }
            }
        }
    }
}