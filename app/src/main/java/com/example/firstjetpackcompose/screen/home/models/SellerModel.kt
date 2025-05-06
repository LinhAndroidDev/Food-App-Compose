package com.example.firstjetpackcompose.screen.home.models

import com.example.firstjetpackcompose.screen.detail_food.models.DetailFoodModel

data class SellerModel(
    val name: String,
    val price: Float,
    val image: String,
    val calories: Int,
    val time: Int
) {
    fun convertToDetailFoodModel(): DetailFoodModel {
        return DetailFoodModel(
            name = name,
            image = image,
            detail = "Description of $name.",
            price = price
        )
    }
}