package com.example.firstjetpackcompose.screen.map.models

data class OrderTakingProcessModel(
    val title: String,
    val time: String,
    var isSelected: Boolean = false
)