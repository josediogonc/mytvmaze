package com.example.mytvmaze.tvmaze.episodes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytvmaze.R
import com.example.mytvmaze.core.ImageFactory
import com.example.mytvmaze.core.ui.fragment.BaseFragment
import com.example.mytvmaze.databinding.FragmentEpisodeDetailsBinding
import com.squareup.picasso.Picasso

class EpisodeDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentEpisodeDetailsBinding
    private val args: EpisodeDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.episodeData = args.episode
        binding.showName = args.showName
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPoster()
    }

    override fun setupToolbar() {
        binding.toolbar.setNavigationIcon(R.drawable.custom_white_back_arrow)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }

    private fun setupPoster() {
        args.episode.poster?.let {
            ImageFactory.load(it.original, binding.ivPoster)
        }
    }
}
