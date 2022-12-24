package com.example.gumbuddy.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gumbuddy.db.DataSource
import com.example.gumbuddy.db.Exercise
import com.example.gumbuddy.db.MuscleGroup

class MuscleGroupViewModel : ViewModel() {

    private val _groups = MutableLiveData<List<MuscleGroup>>()
    val groups: LiveData<List<MuscleGroup>> = _groups
    private val _group = MutableLiveData<MuscleGroup>()
    val group: LiveData<MuscleGroup> = _group

    private val _exercise = MutableLiveData<Exercise>()
    val exercise: LiveData<Exercise> = _exercise
    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> = _exercises

    init {
        getExerciseList()
    }

    fun getExerciseList() {
        _exercises.postValue(DataSource.exercises)
    }

    fun onGroupClicked(group: MuscleGroup) {
        _group.value = group
    }
    fun onExerciseClicked(exercise: Exercise) {
        _exercise.value = exercise
    }
}