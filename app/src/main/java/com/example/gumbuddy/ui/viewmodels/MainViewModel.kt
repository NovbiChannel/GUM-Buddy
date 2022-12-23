package com.example.gumbuddy.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.gumbuddy.db.MuscleGroup
import dagger.hilt.android.lifecycle.HiltViewModel

class MainViewModel(): ViewModel() {

    val groups = MediatorLiveData<List<MuscleGroup>>()
}