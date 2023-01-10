package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gumbuddy.databinding.FragmentExerciseSettingLinearBinding
import com.example.gumbuddy.db.ExerciseSettingLinear
import com.example.gumbuddy.other.Constants.KEY_LINEAR
import com.example.gumbuddy.ui.viewmodels.MainViewModel

class ExerciseSettingLinearFragment : Fragment() {

    private lateinit var binding: FragmentExerciseSettingLinearBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseSettingLinearBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Слушатель уникального ключа активной вкладки ViewPager
        viewModel.fragmentData.observe(viewLifecycleOwner) { key ->
            if (key == KEY_LINEAR) {
                saveExerciseSettingLinear()
            }
        }

    }
    //Сохранение данных линейной настройки упражнения в базу данных Room
    private fun saveExerciseSettingLinear() {
        val idExercise = viewModel.exercise.value?.id
        val approach = binding.edApproach.text.toString().toInt()
        val repeat = binding.edRepeat.text.toString().toInt()
        val weight = binding.edWeight.text.toString().toDouble()
        val comment = binding.edComment.text.toString()
        val settingLinear = ExerciseSettingLinear(idExercise, approach, repeat, weight, comment)
        viewModel.insertExerciseSettingLinear(settingLinear)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExerciseSettingLinearFragment()
    }
}