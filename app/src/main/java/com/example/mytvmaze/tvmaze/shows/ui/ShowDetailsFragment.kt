package com.example.mytvmaze.tvmaze.shows.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.*
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytvmaze.R
import com.example.mytvmaze.core.ui.fragment.BaseFragment
import com.example.mytvmaze.databinding.FragmentShowsDetailsBinding
import com.example.mytvmaze.tvmaze.shows.model.Episode
import com.example.mytvmaze.tvmaze.shows.viewModel.ShowDetailsViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class ShowDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentShowsDetailsBinding
    private val viewModel: ShowDetailsViewModel by viewModel()
    private val args: ShowDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowsDetailsBinding.inflate(inflater, container, false)
        binding.apply {
            showData = args.show
            viewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getEpisodes(args.show.id)
        setupPoster()
        setupRatingBar()
    }

    private fun setupRatingBar() {
        args.show.rating.average?.let {
            binding.ratingBar.rating = it /2
        } ?: run {
            binding.ratingBar.visibility = View.GONE
        }
    }

    private fun setupPoster() {
        Picasso.get().load(args.show.poster?.original).into(binding.ivPoster)
    }

    override fun setupToolbar() {
        binding.toolbar.setNavigationIcon(R.drawable.white_back_arrow)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }

    override fun setupObservers() {
        super.setupObservers()
        episodesListObserver()
    }

    private fun episodesListObserver() {
        viewModel.episodes.observe(viewLifecycleOwner, { list ->
            list?.let {
                val episodesMap = viewModel.getEpisodesMappedBySeason()
                initSeasonsAndEpisodesView(episodesMap)
            }
        })
    }

    private fun initSeasonsAndEpisodesView(episodesMap: MutableMap<Int, List<Episode>>) {
        binding.seasonsEpisodesLayout.removeAllViews()
        for((season, episodes) in episodesMap) {
            addSeasonTextView("Season $season")
            initEpisodesView(episodes)
        }
    }

    private fun initEpisodesView(episodes: List<Episode>) {
        for(episode in episodes) {
            addEpisodeTextView(episode)
        }
    }
    
    private fun navigateToEpisodeDetailsScreen(episode : Episode) {
        val action = ShowDetailsFragmentDirections.actionShowDetailsFragmentToEpisodeDetails(episode, args.show.name)
        findNavController().navigate(action)
    }

    private fun addEpisodeTextView(episode: Episode) {
        val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(10,15,10,15)
        val tvEpisode = TextView(requireContext())
        tvEpisode.apply {
            textSize = 17f
            text = episode.toString()
            setTextColor(resources.getColor(R.color.black))
            setOnClickListener { navigateToEpisodeDetailsScreen(episode) }
        }
        binding.seasonsEpisodesLayout.addView(tvEpisode, layoutParams)
    }

    private fun addSeasonTextView(value: String) {
        val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        layoutParams.setMargins(10,50,10,30)
        //layoutParams.gravity = Gravity.CENTER_HORIZONTAL
        val tvSeason = TextView(requireContext())
        tvSeason.apply {
            textSize = 18f
            text = value.toUpperCase(Locale.getDefault())
            setTextColor(resources.getColor(R.color.color_primary_dark))
        }
        binding.seasonsEpisodesLayout.addView(tvSeason, layoutParams)
    }

}