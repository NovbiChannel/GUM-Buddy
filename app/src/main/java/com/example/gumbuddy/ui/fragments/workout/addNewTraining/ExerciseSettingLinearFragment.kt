package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gumbuddy.databinding.FragmentExerciseSettingLinearBinding

class ExerciseSettingLinearFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentExerciseSettingLinearBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance() = ExerciseSettingLinearFragment()
    }
}