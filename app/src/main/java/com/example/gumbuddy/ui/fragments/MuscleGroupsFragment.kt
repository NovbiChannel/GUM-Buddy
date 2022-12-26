package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.MuscleGroupListAdapter
import com.example.gumbuddy.adapters.MuscleGroupListAdapter.MuscleGroupViewHolder
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

        val toolbarText = "Упражнения"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText

        val adapter = MuscleGroupListAdapter {
            viewModel.updateCurrentGroup(it)
            val action = MuscleGroupsFragmentDirections.actionMuscleGroupsFragmentToAddExerciseFragment()
            this.findNavController().navigate(action)
        }
        binding.rvExercise.adapter = adapter
        adapter.submitList(viewModel.groups)
    }
}