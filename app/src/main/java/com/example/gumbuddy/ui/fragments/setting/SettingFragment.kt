package com.example.gumbuddy.ui.fragments.setting

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gumbuddy.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(R.layout.fragment_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarText = "Настройки"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText

    }
}