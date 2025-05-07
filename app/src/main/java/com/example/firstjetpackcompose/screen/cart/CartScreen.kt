package com.example.firstjetpackcompose.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstjetpackcompose.IconTop
import com.example.firstjetpackcompose.screen.cart.models.CartModel
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.Green
import com.example.firstjetpackcompose.viewmodel.ShareViewModel

@Composable
fun CartScreen(navController: NavController, shareViewModel: ShareViewModel) {
    val carts = listOf(
        CartModel(
            "Fried Sausage Pizza House",
            "Hot Dog",
            2f,
            "https://product.hstatic.net/200000291375/product/sausage_a4daf1e47ebe434b856b4c84cf32c53f_d75c027911094272a2016f063d4aa862_grande.png",
            5
        ),
        CartModel(
            "Crispy Golden Pepper Salted Chicken",
            "Salted Chicken",
            5f,
            "https://kitchencake.vn/thumbs/540x540x2/upload/product/gaumuoi-3622.png",
            2
        ),
        CartModel(
            "Delicious Mixed Rice Paper",
            "Mixed Rice Paper",
            8.0f,
            "https://banhtrangdom.com/wp-content/uploads/2023/06/tron-top-mo.png",
            3
        ),
        CartModel(
            "Pearl Milk Tea - Ice Cream Hung Linh",
            "Milk Tea",
            10.5f,
            "https://kemhunglinh.com/wp-content/uploads/2021/10/kem-tra-sua-1-1.png",
            3
        ),
        CartModel(
            "KEM HỘP 500ml - BỘ 8 HƯƠNG VỊ KEM MERINO",
            "Ice Cream",
            12f,
            "https://kemducmanh.com/wp-content/uploads/2021/06/merino-hop.png",
            2
        ),
        CartModel(
            "Beef Rice Noodles Hue",
            "Noodles",
            3f,
            "https://trungnguyenlegendcafe.net/wp-content/uploads/2025/02/Bun-Bo-TNL-copy-1.png",
            3
        )
    )
    val list = remember { mutableStateOf(carts) }
    val totalPrice = list.value.sumOf { (it.price * it.quantity).toDouble() }.toFloat()
    val delivery = 5f
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackGroundCommon)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, top = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconTop(image = Icons.Filled.ArrowBack, onClick = {})
                Text(
                    text = "Cart",
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W600
                )
                IconTop(image = Icons.Outlined.Delete, onClick = {})
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Column {
                list.value.forEachIndexed { index, cart ->
                    ItemCartView(cartModel = cart, onClick = { cartModel ->
                        shareViewModel.setSelectedFood(cartModel.convertToDetailFoodModel())
                        navController.navigate("detail_food")
                    }, onAdd = {
                        list.value = list.value.toMutableList().apply {
                            this[index] = this[index].copy(quantity = it)
                        }
                    }, onMinus = {
                        list.value = list.value.toMutableList().apply {
                            this[index] = this[index].copy(quantity = it)
                        }
                    })
                }
            }

            PromoCodeView()

            TotalPriceView(total = totalPrice, delivery = delivery)

            Spacer(modifier = Modifier.size(200.dp))
        }

        Text(
            "Checkout • $${totalPrice + delivery}",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 120.dp)
                .fillMaxWidth()
                .background(color = Green, shape = RoundedCornerShape(50.dp))
                .clickable {

                }
                .padding(vertical = 15.dp)
                .align(Alignment.BottomCenter),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen(
        navController = NavController(LocalContext.current),
        shareViewModel = ShareViewModel()
    )
}