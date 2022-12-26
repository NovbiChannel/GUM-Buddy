package com.example.gumbuddy.ui.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.AddExerciseAdapter
import com.example.gumbuddy.adapters.WorkoutAdapter
import com.example.gumbuddy.databinding.FragmentWorkoutBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return FragmentWorkoutBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentWorkoutBinding.bind(view)

        val toolbarText = "Workout"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText

        binding.fab.setOnClickListener {
            val action = WorkoutFragmentDirections.actionWorkoutFragmentToAddTrainingFragment()
            this.findNavController().navigate(action)
        }
    }
}