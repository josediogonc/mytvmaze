package com.example.mytvmaze.tvmaze.shows.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytvmaze.R
import com.example.mytvmaze.core.extensions.*
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        searchClickListener()
        closeSearchClickListener()
    }

    override fun setupToolbar() = Unit

    override fun setupObservers() {
        errorDialogObserver()
        showListLoadedObserver()
        searchListLoadedObserver()
    }

    private fun closeSearchClickListener() {
        binding.ivCloseSearchIcon.setOnClickListener {
            viewModel.toggleCloseSearchOption()
            viewModel.toolbarTitle.value = ShowsViewModel.DEFAULT_TOOLBAR_TITLE
            bindRecyclerViewWithDefault()
        }
    }


    private fun searchClickListener() {
        binding.ivSearchIcon.setOnClickListener {

            DialogFactory.InputDialog(
                requireContext(),
                getString(R.string.search_dialog_title),
                getString(R.string.search_dialog_message),
                getString(R.string.search_dialog_button),
                viewModel.input
            ).show()
        }
    }

    private fun searchListLoadedObserver() {
        viewModel.searchList.observe(viewLifecycleOwner, { searchList ->
            searchList.let {
                if(it.isNotEmpty()) {
                    bindRecyclerViewWithSearchResults()
                }
            }
        })
    }

    private fun bindRecyclerViewWithSearchResults() {
        val shows = viewModel.getShowsFromSearchResult()
        if(viewModel.shouldShowCloseSearchButton.value == true) {
            setupShowListRecyclerView(shows)
        }
    }

    private fun bindRecyclerViewWithDefault() {
        val shows = viewModel.showList.value
        shows?.let {
            setupShowListRecyclerView(it)
        }
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
            scheduleLayoutAnimation()
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