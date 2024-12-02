package com.example.abu_hw2.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.abu_hw2.R
import com.example.abu_hw2.SharedPreferencesHelper
import com.example.abu_hw2.data.LoveApiService
import com.example.abu_hw2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    @Inject
    lateinit var loveApiService: LoveApiService

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.nav_graph)

        if (sharedPreferencesHelper.isOnBoardShown()) {
            navController.navigate(R.id.action_onBoardFragment_to_loveCalculatorFragment)
        }
    }
}