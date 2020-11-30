package com.example.mytvmaze.tvmaze.shows.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytvmaze.core.extensions.supportFragmentManager
import com.example.mytvmaze.databinding.FragmentShowsBinding
import com.example.mytvmaze.core.ui.dialog.DialogFactory
import com.example.mytvmaze.core.ui.fragment.BaseFragment
import com.example.mytvmaze.tvmaze.shows.ShowListAdapter
import com.example.mytvmaze.tvmaze.shows.model.Show
import com.example.mytvmaze.tvmaze.shows.viewModel.ShowsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowsFragment : BaseFragment() {

    private lateinit var binding: FragmentShowsBinding
    private val viewModel: ShowsViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View {
        binding = FragmentShowsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun setupObservers() {
        errorDialogObserver()
        showListLoadedObserver()
    }

    private fun showListLoadedObserver() {
        viewModel.showList.observe(viewLifecycleOwner, { list ->
            list?.let {
                setupShowListRecyclerView(it)
            }
        })
    }

    private fun setupShowListRecyclerView(list: List<Show>) {
        binding.rvShowsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ShowListAdapter(list)
        }
    }

    private fun errorDialogObserver() {
        viewModel.errorDialog.observe(viewLifecycleOwner, { error ->
            error?.let {
                DialogFactory.CustomDialog(
                    error.title,
                    error.message
                ).show(supportFragmentManager, "tag")
            }
        })
    }

}