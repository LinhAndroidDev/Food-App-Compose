package com.example.firstjetpackcompose.screen.detail_food.models

data class IngredientModel(
    val name: String,
    val image: String,
    val quantity: Int,
    val price: Float,
    var isSelected: Boolean = false
)