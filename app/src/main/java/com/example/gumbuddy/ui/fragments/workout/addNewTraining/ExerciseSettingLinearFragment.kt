package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.databinding.FragmentExerciseSettingLinearBinding
import com.example.gumbuddy.db.ExerciseSettingLinear
import com.example.gumbuddy.other.Constants.KEY_APPLY
import com.example.gumbuddy.other.Constants.KEY_CLEAR
import com.example.gumbuddy.other.Constants.KEY_LINEAR
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

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
                saveExerciseSettingLinear(view)
            } else if (key == KEY_CLEAR) {
                clearExerciseSettingLinear()
            }
        }
        viewModel.exercise.observe(viewLifecycleOwner) { keyId ->
            if (keyId.idSetting != 0) {
                Log.d("MyLog", "KeySettingID = ${keyId.idSetting}")
                lifecycleScope.launch {
                    // Заполнение формы при условии если настройки были выполненны
                    val idSetting = viewModel.exercise.value!!.idSetting
                    val model = viewModel.getIdExerciseSettingLinear(idSetting)

                    binding.edApproach.setText(model.approach.toString())
                    binding.edRepeat.setText(model.repeat.toString())
                    binding.edWeight.setText(model.weight.toString())
                    binding.edComment.setText(model.comment)
                }
            }
        }
    }

    //Сохранение данных линейной настройки упражнения в базу данных Room
    private fun saveExerciseSettingLinear(view: View) {
        Log.d("MyLog", "SaveFunction вызвана")

        val idExercise = viewModel.exercise.value?.id
        val approach = binding.edApproach.text
        val repeat = binding.edRepeat.text
        val weight = binding.edWeight.text
        val comment = binding.edComment.text

        if (approach.isEmpty() || repeat.isEmpty() || weight.isEmpty()) {
            Snackbar.make(
                view,
                "Заполните все необходимые поля",
                Snackbar.LENGTH_SHORT
            ).show()
        } else {

            val settingLinear = ExerciseSettingLinear(idExercise, approach.toString().toInt(),
                repeat.toString().toInt(), weight.toString().toDouble(), comment.toString())
            val action = ExerciseSettingFragmentDirections.actionExerciseSettingFragmentToAddTrainingFragment()

            if (comment.isEmpty()) {
                settingLinear.comment = ""
                viewModel.insertExerciseSettingLinear(settingLinear)
                viewModel.updateDataFragment(KEY_APPLY)
                lifecycleScope.launch {
                    viewModel.saveIdExerciseSettingLinear()
                }
                findNavController().navigate(action)

            } else {
                viewModel.insertExerciseSettingLinear(settingLinear)
                viewModel.updateDataFragment(KEY_APPLY)
                lifecycleScope.launch {
                    viewModel.saveIdExerciseSettingLinear()
                }
                findNavController().navigate(action)
            }
        }
    }
    //Очистка формы заполнения
    private fun clearExerciseSettingLinear() {
        binding.edApproach.text.clear()
        binding.edRepeat.text.clear()
        binding.edWeight.text.clear()
        binding.edComment.text.clear()
        //Поиск данных в таблице по идентификатору упражнения, удаление всех записей!
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExerciseSettingLinearFragment()
    }
}