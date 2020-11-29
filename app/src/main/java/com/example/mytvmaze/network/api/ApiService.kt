package com.example.mytvmaze.network.api

import com.example.mytvmaze.network.model.Resource
import com.example.mytvmaze.shows.model.ShowsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/shows")
    suspend fun getShow(@Query("q") query : String) : Response<List<ShowsResponse>>

}