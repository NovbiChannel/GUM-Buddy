package com.example.gumbuddy.ui.fragments.statistics

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.gumbuddy.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarText = "Моя статистика"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
    }
}