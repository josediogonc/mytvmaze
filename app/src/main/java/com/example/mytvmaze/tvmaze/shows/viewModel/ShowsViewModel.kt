package com.example.mytvmaze.tvmaze.shows.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytvmaze.core.viewModel.BaseViewModel
import com.example.mytvmaze.api.repository.ApiRepository
import com.example.mytvmaze.core.network.retrofit.validateResponse
import com.example.mytvmaze.tvmaze.shows.model.Show
import com.example.mytvmaze.tvmaze.shows.model.ShowsResponse
import kotlinx.coroutines.launch

class ShowsViewModel(apiRepository: ApiRepository) : BaseViewModel(apiRepository) {

    companion object {
        const val DEFAULT_TOOLBAR_TITLE = "My TV Maze"
    }

    val showList = MutableLiveData<List<Show>>()
    val searchList = MutableLiveData<List<ShowsResponse>>()
    val input = MutableLiveData("")
    val toolbarTitle = MutableLiveData(DEFAULT_TOOLBAR_TITLE)
    val shouldShowCloseSearchButton = MutableLiveData(false)

    private val inputObserver = androidx.lifecycle.Observer<String> { inputValue ->
        inputValue?.let {
            if (it.isNotEmpty()) {
                toolbarTitle.value = "Searching for '$it'"
                shouldShowCloseSearchButton.value = true
                searchShow(it)
            }
        }
    }

    init {
        getShowsByPage(1)
        initObservable()
    }

    private fun initObservable() {
        input.observeForever(inputObserver)
    }

    fun getShowsByPage(page : Int) {
        viewModelScope.launch {
            loading(true)
            val resource = apiRepository.getShowsByPage(page)
            resource.validateResponse(showList, _errorDialog)
            loading(false)
        }
    }

    private fun searchShow(query : String) {
        if (query.isNotEmpty()) {
            viewModelScope.launch {
                loading(true)
                val resource = apiRepository.getShows(query)
                resource.validateResponse(searchList, _errorDialog)
                loading(false)
            }
        }
    }

    fun getShowsFromSearchResult(): List<Show> {
        val list = ArrayList<Show>()
        searchList.value?.let { showsSearchResponse ->
            showsSearchResponse.forEach { list.add(it.show) }
        }.also { return list }
    }

    override fun onCleared() {
        input.removeObserver(inputObserver)
        super.onCleared()
    }

    fun toggleCloseSearchOption() {
        shouldShowCloseSearchButton.apply {
            value = value != true
        }
    }


}