package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.AddExerciseAdapter
import com.example.gumbuddy.adapters.ExerciseListener
import com.example.gumbuddy.databinding.FragmentAddExerciseBinding
import com.example.gumbuddy.db.Exercise
import com.example.gumbuddy.ui.viewmodels.MuscleGroupViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import kotlin.math.sign

@AndroidEntryPoint
class AddExerciseFragment : Fragment() {

    private val viewModel: MuscleGroupViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddExerciseBinding.inflate(inflater)
        viewModel.getExerciseList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvExercise.adapter = AddExerciseAdapter(ExerciseListener { exercise ->
            viewModel.onExerciseClicked(exercise)
            findNavController()
                .navigate(R.id.action_addExerciseFragment_to_exerciseInformationFragment)
        })

        return binding.root
    }

}