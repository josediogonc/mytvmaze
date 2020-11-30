package com.example.mytvmaze.tvmaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.mytvmaze.R
import com.example.mytvmaze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)
/*
        val navController = Navigation.findNavController(this, R.id.fragment_navhost)
        val navInflater = navController.navInflater
        val graph = navInflater.inflate(R.navigation.app_navigation)
        navController.graph = graph*/


    }
}