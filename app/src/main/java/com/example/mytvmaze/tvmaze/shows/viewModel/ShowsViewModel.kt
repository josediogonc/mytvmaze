package com.example.mytvmaze.tvmaze.shows.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytvmaze.core.viewModel.BaseViewModel
import com.example.mytvmaze.api.repository.ApiRepository
import com.example.mytvmaze.core.network.retrofit.validateResponse
import com.example.mytvmaze.tvmaze.shows.model.Show
import kotlinx.coroutines.launch


class ShowsViewModel(apiRepository: ApiRepository) : BaseViewModel(apiRepository) {

    val showList = MutableLiveData<List<Show>>()

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

    //TODO
    fun searchShow(query : String) {
        viewModelScope.launch {
            loading(true)
            //val resource = apiRepository.getShowsByPage(page) TODO
            //resource.validateResponse(showList, _errorDialog)
            loading(false)
        }
    }


}