package com.example.gumbuddy.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gumbuddy.db.DataSource
import com.example.gumbuddy.db.Exercise
import com.example.gumbuddy.db.MuscleGroup

class MainViewModel : ViewModel() {

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

    fun updateCurrentGroup(group: MuscleGroup) {
        _group.value = group
    }

    fun updateCurrentExercise(exercise: Exercise) {
        _exercise.value = exercise
    }
}