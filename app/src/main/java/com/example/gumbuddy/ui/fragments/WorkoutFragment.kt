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
import com.example.gumbuddy.databinding.FragmentWorkoutBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
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

        val toolbarText = "Тренировки"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText

        binding.fab.setOnClickListener {
            val action = WorkoutFragmentDirections.actionWorkoutFragmentToAddTrainingFragment()
            this.findNavController().navigate(action)
        }
    }
}