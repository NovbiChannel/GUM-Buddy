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
import com.example.gumbuddy.adapters.GroupListener
import com.example.gumbuddy.adapters.MuscleGroupAdapter
import com.example.gumbuddy.databinding.FragmentMuscleGroupsBinding
import com.example.gumbuddy.ui.viewmodels.MuscleGroupViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuscleGroupsFragment : Fragment(R.layout.fragment_muscle_groups) {

    private lateinit var binding: FragmentMuscleGroupsBinding
    private val viewModel: MuscleGroupViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuscleGroupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() = binding.rvExercise.apply {
        adapter = MuscleGroupAdapter(GroupListener { group ->
            viewModel.onGroupClicked(group)
            findNavController()
                .navigate(R.id.action_muscleGroupsFragment_to_addExerciseFragment)
            //написать алгоритм поиска сортировки списка по айди
        })
        layoutManager = LinearLayoutManager(requireContext())
    }
}