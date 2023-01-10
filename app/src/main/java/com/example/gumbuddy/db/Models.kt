package com.example.gumbuddy.db

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MuscleGroup(
    val id: Int,
    val name: String,
    val imgSrc: Int
)

data class Exercise(
    val id: Int,
    val idGroup: Int,
    val name: String,
    val description: String,
    val iconSrc: Int,
    val imgSrc: Int,
    var checkExercise: Boolean = false
)

@Entity(tableName = "training_table")
data class Training (
    var idExercise: Int? = null,
    var idExerciseSettingLinear: Int? = null,
    var idExerciseSettingPyramid: Int? = null,
    var trainingName: String = "",

        ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

@Entity(tableName = "exercise_setting_linear_table")
data class ExerciseSettingLinear(
    var idExercise: Int? = null,
    var approach: Int? = 0,
    var repeat: Int? = 0,
    var weight: Double? = 0.0,
    var comment: String = "",
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

@Entity(tableName = "exercise_setting_pyramid_table")
data class ExerciseSettingPyramid(
    var idExercise: Int? = null,
    var approach: Int? = 0,
    var repeat1: Int? = 0,
    var repeat2: Int? = 0,
    var repeat3: Int? = 0,
    var repeat4: Int? = 0,
    var weight1: Double? = 0.0,
    var weight2: Double? = 0.0,
    var weight3: Double? = 0.0,
    var weight4: Double? = 0.0,
    var comment: String = "",
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}