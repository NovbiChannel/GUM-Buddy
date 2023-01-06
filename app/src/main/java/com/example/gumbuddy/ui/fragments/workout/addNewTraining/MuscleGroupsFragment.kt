package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.MuscleGroupListAdapter
import com.example.gumbuddy.databinding.FragmentMuscleGroupsBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuscleGroupsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMuscleGroupsBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMuscleGroupsBinding.bind(view)
        toolBarNav()

        val adapter = MuscleGroupListAdapter {
            viewModel.updateCurrentGroup(it)
            val action = MuscleGroupsFragmentDirections.actionMuscleGroupsFragmentToAddExerciseFragment()
            this.findNavController().navigate(action)
            hideIcon()
        }
        binding.rvExercise.adapter = adapter
        adapter.submitList(viewModel.groups)

        binding.btnCleanTraining.setOnClickListener {
            viewModel.clearExerciseToTheTrainingList()
        }
    }

    private fun toolBarNav() {
        val toolbarText = "Упражнения"
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
        iconToolbar.visibility = View.VISIBLE
        iconToolbar.setOnClickListener {
            val action = MuscleGroupsFragmentDirections.actionMuscleGroupsFragmentToAddTrainingFragment()
            this.findNavController().navigate(action)
            iconToolbar.visibility = View.INVISIBLE
        }
    }

    private fun hideIcon() {
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)
        iconToolbar.visibility = View.INVISIBLE
    }
}