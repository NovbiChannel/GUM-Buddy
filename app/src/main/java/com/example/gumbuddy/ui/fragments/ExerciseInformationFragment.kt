package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gumbuddy.databinding.FragmentExerciseInformationBinding
import com.example.gumbuddy.ui.viewmodels.MuscleGroupViewModel

class ExerciseInformationFragment: Fragment() {

    private val viewModel: MuscleGroupViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentExerciseInformationBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}