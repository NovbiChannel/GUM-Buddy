package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.AddExerciseAdapter
import com.example.gumbuddy.databinding.FragmentAddExerciseBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddExerciseFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAddExerciseBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddExerciseBinding.bind(view)
        toolBarNav()

        val adapter = AddExerciseAdapter {
            viewModel.updateCurrentExercise(it)
            val action = AddExerciseFragmentDirections.actionAddExerciseFragmentToExerciseInformationFragment()
            this.findNavController().navigate(action)
        }
        binding.rvExercise.adapter = adapter
        adapter.submitList(viewModel.searchExerciseForId())

        binding.btnSaveTraining.setOnClickListener {
            viewModel.addExerciseToTheTrainingList()
            val action = AddExerciseFragmentDirections.actionAddExerciseFragmentToAddTrainingFragment()
            this.findNavController().navigate(action)
            iconToolBarNav()
        }
    }

    private fun toolBarNav() {
        val toolbarText = viewModel.group.value?.name
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
        iconToolbar.setImageResource(R.drawable.ic_chevron_left_32)
        iconToolbar.visibility = View.VISIBLE
        iconToolbar.setOnClickListener {
            val action = AddExerciseFragmentDirections.actionAddExerciseFragmentToMuscleGroupsFragment()
            this.findNavController().navigate(action)
            iconToolBarNav()
            iconToolbar.visibility = View.INVISIBLE
        }
    }

    private fun iconToolBarNav() {
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)
        iconToolbar.setImageResource(R.drawable.ic_close_32)
    }

}