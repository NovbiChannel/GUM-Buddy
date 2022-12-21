package com.example.gumbuddy.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.databinding.FragmentSetupBinding
import com.example.gumbuddy.other.Constants.KEY_FIRST_TIME_TOGGLE
import com.example.gumbuddy.other.Constants.KEY_NAME
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SetupFragment : Fragment(R.layout.fragment_setup) {

    @Inject
    lateinit var sharedPref: SharedPreferences

    private lateinit var binding: FragmentSetupBinding

    @set: Inject
    var isFirstAppOpen = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isFirstAppOpen) {
            val navOption = NavOptions.Builder()
                .setPopUpTo(R.id.setupFragment, true)
                .build()
            findNavController().navigate(
                R.id.action_setupFragment_to_homeFragment,
                savedInstanceState,
                navOption
            )
        }

        binding.loginButton.setOnClickListener {
            val success = writeNameToSharedPref()
            if (success) {
                findNavController().navigate(R.id.action_setupFragment_to_homeFragment)
            } else {
                Snackbar.make(
                    binding.root,
                    "Please enter your name",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun writeNameToSharedPref(): Boolean {
        val name = binding.etNameUser.text.toString()
        if (name.isEmpty()) {
            return false
        } else {
            sharedPref.edit()
                .putString(KEY_NAME, name)
                .putBoolean(KEY_FIRST_TIME_TOGGLE, false)
                .apply()
            return true
        }
    }
}