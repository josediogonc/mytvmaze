package com.example.mytvmaze.network.api

import com.example.mytvmaze.network.model.Resource
import com.example.mytvmaze.network.model.RetrofitResponse
import com.example.mytvmaze.shows.model.ShowsResponse
import retrofit2.Call

class ApiRepositoryImpl(private val apiService: ApiService) : ApiRepository {

    override suspend fun getShows(query: String) : Resource<List<ShowsResponse>> {
        return  RetrofitResponse { apiService.getShow(query) }.result()
    }
}