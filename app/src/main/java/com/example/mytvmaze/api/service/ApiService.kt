package com.example.mytvmaze.api.service

import com.example.mytvmaze.tvmaze.shows.model.Episode
import com.example.mytvmaze.tvmaze.shows.model.Show
import com.example.mytvmaze.tvmaze.shows.model.ShowsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/shows")
    suspend fun getShow(@Query("q") query: String): Response<List<ShowsResponse>>

    @GET("shows")
    suspend fun getShowsByPage(@Query("page") page: Int): Response<List<Show>>

    @GET("shows/{id}/episodes")
    suspend fun getEpisodes(@Path("id") showId: Int): Response<List<Episode>>

}