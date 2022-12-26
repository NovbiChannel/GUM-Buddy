package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.gumbuddy.databinding.FragmentExerciseInformationBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel

class ExerciseInformationFragment: Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentExerciseInformationBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentExerciseInformationBinding.bind(view)

        viewModel.exercise.observe(this.viewLifecycleOwner) {
            binding.ivImageExercise.load(it.imgSrc)
            binding.tvTitleExercice.text = it.name
            binding.tvDescriptionExercice.text = it.description
        }
    }
}