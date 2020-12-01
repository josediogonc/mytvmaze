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

    val showList = MutableLiveData<List<Show>>()
    val searchList = MutableLiveData<List<ShowsResponse>>()
    val input = MutableLiveData("")
    val toolbarTitle = MutableLiveData("My TV Maze")

    init {
        getShowsByPage(1)
    }

    fun getShowsByPage(page : Int) {
        viewModelScope.launch {
            loading(true)
            val resource = apiRepository.getShowsByPage(page)
            resource.validateResponse(showList, _errorDialog)
            loading(false)
        }
    }

    fun searchShow(query : String) {
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

}