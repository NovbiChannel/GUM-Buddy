package com.example.gumbuddy.db

import com.example.gumbuddy.R

data class testDB(
    val id: Int = 1,
    val name: String = "Жим лёжа на скамье",
    val description: String = "Базовое физическое упражнение со свободным весом. Выполняющий упражнение ложится на скамейку, опускает гриф до касания с грудью и поднимает до полного выпрямления в локтевом суставе. Используется в бодибилдинге как упражнение для развития больших и малых грудных мышц, трицепсов и переднего пучка дельтовидной мышцы.",
    val muscleGroup: Int = 1,
    val imgSrc: Int = R.drawable.zhim
) {
}