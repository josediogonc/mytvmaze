package com.example.mytvmaze.shows.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytvmaze.databinding.FragmentShowsDetailsBinding


class ShowDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding = FragmentShowsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

}