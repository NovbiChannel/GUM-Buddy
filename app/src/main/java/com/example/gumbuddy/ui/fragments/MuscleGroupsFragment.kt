package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.MuscleGroupAdapter
import com.example.gumbuddy.databinding.FragmentMuscleGroupsBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuscleGroupsFragment : Fragment(R.layout.fragment_muscle_groups) {

    private lateinit var binding: FragmentMuscleGroupsBinding

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
        adapter = MuscleGroupAdapter()
        layoutManager = LinearLayoutManager(requireContext())
    }

}