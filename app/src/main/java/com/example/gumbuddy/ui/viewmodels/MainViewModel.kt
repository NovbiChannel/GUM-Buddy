package com.example.gumbuddy.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gumbuddy.db.*
import com.example.gumbuddy.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private var _fragmentData: MutableLiveData<String> = MutableLiveData()
    val fragmentData: LiveData<String>
        get() = _fragmentData

    private var _group: MutableLiveData<MuscleGroup> = MutableLiveData<MuscleGroup>()
    val group: LiveData<MuscleGroup>
        get() = _group

    private var _groups: ArrayList<MuscleGroup> = ArrayList()
    val groups: ArrayList<MuscleGroup>
        get() = _groups

    private var _exercise: MutableLiveData<Exercise> = MutableLiveData<Exercise>()
    val exercise: LiveData<Exercise>
        get() = _exercise

    private var _exercises: ArrayList<Exercise> = ArrayList()
    val exercises: ArrayList<Exercise>
        get() = _exercises

    init {
        _exercises = DataSource.getExerciseData()
        _exercise.value = _exercises[0]

        _groups = DataSource.getGroupsData()
        _group.value = _groups[0]
    }
    //Функции обновления данных
    fun updateCurrentGroup(group: MuscleGroup) {
        _group.value = group
    }

    fun updateCurrentExercise(exercise: Exercise) {
        _exercise.value = exercise
    }

    fun updateDataFragment(data: String) {
        _fragmentData.value = data
    }
    //Группировка упражнений по группам мышц, создание нового списка упражнений
    fun searchExerciseForId(groupId: Int? = _group.value?.id): MutableList<Exercise> {
        val newExercise = mutableListOf<Exercise>()
        val exerciseArraySize = _exercises.size
        for (i in 0 until exerciseArraySize) {
            if (groupId == _exercises[i].idGroup) {
                newExercise.add(_exercises[i])
            }
        }
        return newExercise
    }
    //Проверка выбора упражнения на истинность, создание нового списка выбранных упражнений
    fun addExerciseToTheTrainingList(): MutableList<Exercise> {
        val trainingList = mutableListOf<Exercise>()
        val exerciseArrayList = _exercises.size
        for (i in 0 until  exerciseArrayList) {
            if (_exercises[i].checkExercise) {
                trainingList.add(_exercises[i])
            }
        }
        return trainingList
    }
    //Установка дефолтного значения проверки выбора
    fun clearExerciseToTheTrainingList() {
        val exerciseArrayList = _exercises.size
        for (i in 0 until exerciseArrayList) {
            if (_exercises[i].checkExercise) {
                _exercises[i].checkExercise = false
            }
        }
        addExerciseToTheTrainingList().clear()
    }
    //Сохранение тренировки в базу данных Room
    fun insertTraining(training: Training) = viewModelScope.launch {
        mainRepository.insertTraining(training)
    }
    //Сохранение настроек упражнения линейного типа в базу данных Room
    fun insertExerciseSettingLinear(exerciseSettingLinear: ExerciseSettingLinear) = viewModelScope.launch {
        mainRepository.insertExerciseSettingLinear(exerciseSettingLinear)
    }
    //Сохранение настроек упражнения пирамидного типа в базу данных Room
    fun insertExerciseSettingPyramid(exerciseSettingPyramid: ExerciseSettingPyramid) = viewModelScope.launch {
        mainRepository.insertExerciseSettingPyramid(exerciseSettingPyramid)
    }
}