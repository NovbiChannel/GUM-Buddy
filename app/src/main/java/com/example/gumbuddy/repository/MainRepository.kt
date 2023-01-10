package com.example.gumbuddy.repository

import com.example.gumbuddy.db.*
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val trainingDao: TrainingDao,
    private val linearDao: LinearDao,
    private val pyramidDao: PyramidDao
) {
    suspend fun insertTraining(training: Training) = trainingDao.insertTraining(training)
    suspend fun insertExerciseSettingLinear(exerciseSettingLinear: ExerciseSettingLinear) = linearDao.insertExerciseSettingLinear(exerciseSettingLinear)
    suspend fun insertExerciseSettingPyramid(exerciseSettingPyramid: ExerciseSettingPyramid) = pyramidDao.insertExerciseSettingPyramid(exerciseSettingPyramid)
}