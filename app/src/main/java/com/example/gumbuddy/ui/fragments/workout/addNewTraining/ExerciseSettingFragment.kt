package com.example.gumbuddy.ui.fragments.workout.addNewTraining

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.adapters.VpAdapter
import com.example.gumbuddy.databinding.FragmentExerciseSettingBinding
import com.example.gumbuddy.databinding.FragmentSettingBinding
import com.example.gumbuddy.ui.viewmodels.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

@Suppress("UNUSED_EXPRESSION")
class ExerciseSettingFragment: Fragment() {

    private val fList = listOf(
        ExerciseSettingLinearFragment.newInstance(),
        ExerciseSettingPyramidFragment.newInstance()
    )
    private val tList = listOf(
        "Линейная",
        "Пирамида"
    )
    private lateinit var binding: FragmentExerciseSettingBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        toolBarNav()
    }

    private fun init() = with(binding) {
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp2.adapter = adapter
        TabLayoutMediator(tabLayout, vp2) {
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }

    @SuppressLint("SetTextI18n")
    private fun toolBarNav() {
        val toolbarText = viewModel.exercise.value?.name
        val limit = 18
        if (toolbarText!!.length > limit) {
            val toolbarValidateText = toolbarText.substring(0, limit)
            requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = "$toolbarValidateText..."
        } else {
            requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
        }
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)

        iconToolbar.visibility = View.VISIBLE
        iconToolbar.setOnClickListener {
            val action = ExerciseSettingFragmentDirections.actionExerciseSettingFragmentToAddTrainingFragment()
            this.findNavController().navigate(action)
            hideIcon()
        }
    }

    private fun hideIcon() {
        val iconToolbar = requireActivity().findViewById<ImageButton>(R.id.icon_navigation)
        iconToolbar.visibility = View.INVISIBLE
    }
}