package com.example.gumbuddy.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (
    entities = [Training::class, ExerciseSettingLinear::class, ExerciseSettingPyramid::class],
    version = 1
        )
abstract class TrainingDatabase: RoomDatabase() {

    abstract fun getTrainingDao(): TrainingDao
    abstract fun getLinearDao(): LinearDao
    abstract fun getPyramidDao(): PyramidDao
}