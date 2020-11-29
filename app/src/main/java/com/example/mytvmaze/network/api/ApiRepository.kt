package com.example.mytvmaze.network.api

import com.example.mytvmaze.network.model.Resource
import com.example.mytvmaze.shows.model.ShowsResponse
import retrofit2.Call
import retrofit2.http.Query

interface ApiRepository {

    suspend fun getShows(@Query("q") query : String) : Resource<List<ShowsResponse>>

}