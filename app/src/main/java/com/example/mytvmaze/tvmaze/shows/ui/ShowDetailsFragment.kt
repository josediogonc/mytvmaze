package com.example.mytvmaze.tvmaze.shows.ui

import android.R.attr.bottom
import android.R.attr.top
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytvmaze.R
import com.example.mytvmaze.core.ui.fragment.BaseFragment
import com.example.mytvmaze.databinding.FragmentShowsDetailsBinding
import com.example.mytvmaze.tvmaze.shows.viewModel.ShowDetailsViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShowDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentShowsDetailsBinding
    private val viewModel: ShowDetailsViewModel by viewModel()
    private val args: ShowDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowsDetailsBinding.inflate(inflater, container, false)
        binding.showData = args.show
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.getEpisodes(args.show.id)

        val tv_dynamic = TextView(requireContext())
        tv_dynamic.textSize = 16f
        tv_dynamic.text = "This is a dynamic TextView generated programma tically in Kotlin"

        binding.seasonsEpisodesLayout.addView(tv_dynamic)

        return binding.root
    }

    private fun setupPoster() {
        Picasso.get().load(args.show.poster.original).into(binding.ivPoster)
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationIcon(R.drawable.white_back_arrow)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupPoster()


    }



}