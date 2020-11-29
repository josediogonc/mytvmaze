package com.example.mytvmaze.api.repository

import com.example.mytvmaze.core.network.retrofit.model.Resource
import com.example.mytvmaze.tvmaze.shows.model.Episode
import com.example.mytvmaze.tvmaze.shows.model.Show
import com.example.mytvmaze.tvmaze.shows.model.ShowsResponse
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRepository {

    suspend fun getShows(@Query("q") query: String): Resource<List<ShowsResponse>>
    suspend fun getShowsByPage(@Query("page") page: Int): Resource<List<Show>>
    suspend fun getShowById(@Path("id") id: Int): Resource<Show>
    suspend fun getEpisodes(@Path("id") showId: Int): Resource<List<Episode>>

}