package com.example.gumbuddy.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TrainingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTraining(training: Training)
}

@Dao
interface LinearDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseSettingLinear(exerciseSettingLinear: ExerciseSettingLinear)
}

@Dao
interface PyramidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseSettingPyramid(exerciseSettingPyramid: ExerciseSettingPyramid)
}