package com.example.gumbuddy.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrainingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTraining(training: Training)
}

@Dao
interface LinearDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseSettingLinear(exerciseSettingLinear: ExerciseSettingLinear)

    @Query("SELECT * FROM exercise_setting_linear_table WHERE id = :id")
    fun getIdExerciseSettingLinear(id: Int?): ExerciseSettingLinear

    @Query("SELECT MAX(id) FROM exercise_setting_linear_table")
    fun getLastIdExerciseSettingLinear(): Int
}

@Dao
interface PyramidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseSettingPyramid(exerciseSettingPyramid: ExerciseSettingPyramid)
}