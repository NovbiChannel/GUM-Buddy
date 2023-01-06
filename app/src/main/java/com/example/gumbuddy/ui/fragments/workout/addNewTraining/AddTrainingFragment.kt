package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.WorkoutAdapter
import com.example.gumbuddy.databinding.FragmentAddTrainingBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTrainingFragment: Fragment(){

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAddTrainingBinding.inflate(inflater, container, false).root
    }

    @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddTrainingBinding.bind(view)
        toolBarNav(view)
        rcAdapterView(view)

        binding.btnAddNewExercise.setOnClickListener {
            val action = AddTrainingFragmentDirections.actionAddTrainingFragmentToMuscleGroupsFragment()
            this.findNavController().navigate(action)
        }

        binding.btnCleanTraining.setOnClickListener {
            viewModel.clearExerciseToTheTrainingList()
            binding.rcViewNewTraining.removeAllViews()
            rcAdapterView(view)
        }
    }

    private fun rcAdapterView(view: View) {
        val binding = FragmentAddTrainingBinding.bind(view)
        //Условия отображения RcView, обработчик состояния кнопки сохранения данных
        if (viewModel.addExerciseToTheTrainingList().isEmpty()) {
            binding.rcViewNewTraining.visibility = View.GONE
            //Состояние ВЫКЛЮЧЕНО
            binding.btnSaveTraining.isEnabled = false
            binding.btnSaveTraining.setTextColor(Color.parseColor("#696363"))
        } else {
            binding.rcViewNewTraining.visibility = View.VISIBLE
            //Состояние ВКЛЮЧЕНО
            binding.btnSaveTraining.isEnabled = true
            binding.btnSaveTraining.setTextColor(Color.parseColor("#ffffff"))

            val adapter = WorkoutAdapter {
                viewModel.updateCurrentExercise(it)
                val action = AddTrainingFragmentDirections.actionAddTrainingFragmentToExerciseSettingFragment()
                this.findNavController().navigate(action)
            }
            binding.rcViewNewTraining.adapter = adapter
            adapter.submitList(viewModel.addExerciseToTheTrainingList())
        }
    }

    private fun toolBarNav(view: View) {
        val toolbarText = "Создать тренировку"
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)
        val binding = FragmentAddTrainingBinding.bind(view)

        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
        iconToolbar.visibility = View.VISIBLE
        iconToolbar.setOnClickListener {
            if (binding.rcViewNewTraining.isEmpty()) {
                val action = AddTrainingFragmentDirections.actionAddTrainingFragmentToWorkoutFragment()
                this.findNavController().navigate(action)
                iconToolbar.visibility = View.INVISIBLE
            } else {
                Snackbar.make(
                    view,
                    "Test else",
                    Snackbar.LENGTH_LONG
                ).show()
                //создать диалог для отмены составленной тренировки
            }
        }
    }
}