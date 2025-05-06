package com.example.firstjetpackcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.firstjetpackcompose.screen.detail_food.models.DetailFoodModel

class ShareViewModel : ViewModel() {
    var selectedFood = mutableStateOf<DetailFoodModel?>(null)

    fun setSelectedFood(food: DetailFoodModel) {
        selectedFood.value = food
    }
}