package com.example.mytvmaze.tvmaze.episodes.ui;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mytvmaze.databinding.FragmentEpisodeDetailsBinding

class EpisodeDetailsFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
            val binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
            return binding.root
        }
}
