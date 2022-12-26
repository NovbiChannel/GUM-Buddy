package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.WorkoutAdapter
import com.example.gumbuddy.databinding.FragmentAddTrainingBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel

class AddTrainingFragment: Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAddTrainingBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddTrainingBinding.bind(view)

        val toolbarText = "Создать тренировку"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText

        if (viewModel.addExerciseToTheTrainingList().isEmpty()) {
            binding.rcViewNewTraining.visibility = View.GONE
        } else {
            binding.rcViewNewTraining.visibility = View.VISIBLE
            val adapter = WorkoutAdapter {
                viewModel.updateCurrentExercise(it)
//                val action = WorkoutFragmentDirections.actionWorkoutFragmentToMuscleGroupsFragment()
//                this.findNavController().navigate(action)
            }
            binding.rcViewNewTraining.adapter = adapter
            adapter.submitList(viewModel.addExerciseToTheTrainingList())
        }

        binding.btnAddNewExercise.setOnClickListener {
            val action = AddTrainingFragmentDirections.actionAddTrainingFragmentToMuscleGroupsFragment()
            this.findNavController().navigate(action)
        }
    }
}