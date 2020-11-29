package com.example.mytvmaze.core.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    fun build(url: String, client: OkHttpClient, moshiConverter: MoshiConverterFactory) =
        Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(moshiConverter)
            .build()

}