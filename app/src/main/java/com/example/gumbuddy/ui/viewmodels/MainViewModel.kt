package com.example.gumbuddy.ui.viewmodels

import android.util.Log
import android.widget.CheckBox
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gumbuddy.db.DataSource
import com.example.gumbuddy.db.Exercise
import com.example.gumbuddy.db.MuscleGroup

class MainViewModel : ViewModel() {

    private var _isFirstOpenWorkout: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isFirstOpenWorkout: LiveData<Boolean>
        get() = _isFirstOpenWorkout

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
        _isFirstOpenWorkout.value = false

        _exercises = DataSource.getExerciseData()
        _exercise.value = _exercises[0]

        _groups = DataSource.getGroupsData()
        _group.value = _groups[0]
    }

    fun updateCurrentGroup(group: MuscleGroup) {
        _group.value = group
    }

    fun updateCurrentExercise(exercise: Exercise) {
        _exercise.value = exercise
    }

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

    fun addExerciseToTheTrainingList(): MutableList<Exercise> {
        val trainingList = mutableListOf<Exercise>()
        val exerciseArrayList = _exercises.size
        for (i in 0 until  exerciseArrayList) {
            if (_exercises[i].checkExercise) {
                trainingList.add(_exercises[i])
            }
        }
        _isFirstOpenWorkout.value = false
        return trainingList
    }
}