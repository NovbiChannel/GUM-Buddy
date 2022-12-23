package com.example.gumbuddy.db

import androidx.annotation.DrawableRes
import com.example.gumbuddy.R

data class MuscleGroup(
    val id: Int,
    val name: String,
    @DrawableRes val imgSrc: Int
) {
}