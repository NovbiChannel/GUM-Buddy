package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gumbuddy.databinding.FragmentExerciseSettingPyramidBinding
import com.example.gumbuddy.other.Constants.KEY_PYRAMID
import com.example.gumbuddy.ui.viewmodels.MainViewModel

class ExerciseSettingPyramidFragment : Fragment() {

    private lateinit var binding: FragmentExerciseSettingPyramidBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseSettingPyramidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Слушатель уникального ключа активной вкладки ViewPager
        viewModel.fragmentData.observe(viewLifecycleOwner) { key ->
            if (key == KEY_PYRAMID) {
                Log.d("MyTag", "Запуск функции")
                //Сохранение данных пирамидного типа
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExerciseSettingPyramidFragment()
    }

}