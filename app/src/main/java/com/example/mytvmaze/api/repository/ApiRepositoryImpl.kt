package com.example.mytvmaze.api.repository

import android.content.Context
import com.example.mytvmaze.api.service.ApiService
import com.example.mytvmaze.core.network.retrofit.model.RetrofitResponse

class ApiRepositoryImpl(val context: Context, private val api: ApiService) : ApiRepository {

    override suspend fun getShows(query: String) = RetrofitResponse(context) { api.getShow(query) }.result()
    override suspend fun getShowsByPage(page: Int) = RetrofitResponse(context) { api.getShowsByPage(page) }.result()
    override suspend fun getEpisodes(showId: Int) = RetrofitResponse(context) { api.getEpisodes(showId) }.result()

}