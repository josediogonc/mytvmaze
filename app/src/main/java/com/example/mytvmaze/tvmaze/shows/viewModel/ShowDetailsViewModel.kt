package com.example.mytvmaze.tvmaze.shows.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytvmaze.core.viewModel.BaseViewModel
import com.example.mytvmaze.api.repository.ApiRepository
import com.example.mytvmaze.core.network.retrofit.validateResponse
import com.example.mytvmaze.tvmaze.shows.model.Episode
import kotlinx.coroutines.launch

class ShowDetailsViewModel(apiRepository: ApiRepository) : BaseViewModel(apiRepository) {

    val episodes = MutableLiveData<List<Episode>>()

    fun getEpisodes(showId : Int) {
        viewModelScope.launch {
            loading(true)
            val resource = apiRepository.getEpisodes(showId)
            resource.validateResponse(episodes, _errorDialog)
        }
    }

    fun getEpisodesMappedBySeason() : MutableMap<Int, List<Episode>> {
        val episodesMap = mutableMapOf<Int,List<Episode>>()

        episodes.value?.let { episodesList ->
            val seasons = mutableListOf<Int>()
            episodesList.forEach { seasons.add(it.season) }

            for (season in seasons.distinct()) {
                val episodesFromSeason = episodesList.filter { it.season == season }
                episodesMap.put(season, episodesFromSeason)
            }

        }

        return episodesMap
    }
}