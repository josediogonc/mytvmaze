package com.example.mytvmaze.api.repository

import com.example.mytvmaze.api.service.ApiService
import com.example.mytvmaze.core.network.retrofit.toResource

class ApiRepositoryImpl(private val api: ApiService) : ApiRepository {

    override suspend fun getShows(query: String) = api.getShow(query).toResource()
    override suspend fun getShowsByPage(page: Int) = api.getShowsByPage(page).toResource()
    override suspend fun getEpisodes(showId: Int) = api.getEpisodes(showId).toResource()

}