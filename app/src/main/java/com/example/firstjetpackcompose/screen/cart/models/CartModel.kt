package com.example.firstjetpackcompose.screen.cart.models

import com.example.firstjetpackcompose.screen.detail_food.models.DetailFoodModel

data class CartModel(
    val name: String,
    val detail: String,
    val price: Float,
    val image: String,
    var quantity: Int
) {
    fun convertToDetailFoodModel(): DetailFoodModel {
        return DetailFoodModel(
            name = name,
            image = image,
            detail = detail,
            price = price
        )
    }
}