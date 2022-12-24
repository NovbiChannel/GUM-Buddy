package com.example.gumbuddy.db

import androidx.annotation.DrawableRes

data class MuscleGroup(
    val id: Int,
    val name: String,
    @DrawableRes val imgSrc: Int
)

data class Exercise(
    val id: Int,
    val idGroup: Int,
    val name: String,
    val description: String,
    @DrawableRes val iconSrc: Int,
    @DrawableRes val imgSrc: Int
)