package com.example.mytvmaze.tvmaze.shows.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mytvmaze.databinding.FragmentShowsDetailsBinding
import com.example.mytvmaze.tvmaze.shows.viewModel.ShowDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.mytvmaze.core.ui.fragment.BaseFragment


class ShowDetailsFragment : BaseFragment() {

    private val viewModel: ShowDetailsViewModel by viewModel()
    private val args: ShowDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding = FragmentShowsDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getShowDetails(args.showId)
    }



}