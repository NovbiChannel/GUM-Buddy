package com.example.gumbuddy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gumbuddy.R
import com.example.gumbuddy.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        setSupportActionBar(binding.toolbar)
        binding.bottomNavigationView.setupWithNavController(navController)

        navController
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.workoutFragment, R.id.statisticsFragment, R.id.homeFragment, R.id.directoryFragment,
                        R.id.settingFragment -> {
                        binding.bottomNavigationView.visibility = View.VISIBLE
                        binding.appBarLayout.visibility = View.VISIBLE
                        }
                    else -> {
                        binding.bottomNavigationView.visibility = View.GONE
                        binding.appBarLayout.visibility = View.GONE
                    }
                }
            }
    }

}