package com.example.mytvmaze.shows.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytvmaze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

    }
}