package com.example.gumbuddy.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.databinding.FragmentWorkoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : Fragment(R.layout.fragment_workout) {

    private lateinit var binding: FragmentWorkoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarText = "Workout"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText

        binding.fab.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {

        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.fragment_add_training)
        val btnAddTraining = dialog.findViewById<ImageButton>(R.id.btnAddNewExercise)
        val btnClean = dialog.findViewById<Button>(R.id.btnCleanTraining)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveTraining)

        btnAddTraining?.setOnClickListener {
            findNavController().navigate(R.id.action_workoutFragment_to_muscleGroupsFragment)
            dialog.dismiss()
        }

        dialog.show()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes!!.windowAnimations = R.style.DialogAnimation

    }
}