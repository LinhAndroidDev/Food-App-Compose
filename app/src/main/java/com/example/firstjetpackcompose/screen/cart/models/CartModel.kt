package com.example.firstjetpackcompose.screen.cart.models

data class CartModel(
    val name: String,
    val detail: String,
    val price: Float,
    val image: String,
    var quantity: Int
)