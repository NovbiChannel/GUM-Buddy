package com.example.gumbuddy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gumbuddy.R
import com.example.gumbuddy.databinding.FragmentDirectoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DirectoryFragment : Fragment(R.layout.fragment_directory) {

    private lateinit var binding: FragmentDirectoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDirectoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarText = "Справочник"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
    }
}