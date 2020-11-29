package com.example.mytvmaze.core.di.koin

import org.koin.dsl.module
import com.example.mytvmaze.BuildConfig
import com.example.mytvmaze.api.repository.ApiRepository
import com.example.mytvmaze.api.repository.ApiRepositoryImpl
import com.example.mytvmaze.api.service.ApiService
import com.example.mytvmaze.core.network.retrofit.OkHttpClientFactory
import com.example.mytvmaze.core.network.retrofit.RetrofitFactory
import com.example.mytvmaze.database.DatabaseFactory
import com.example.mytvmaze.tvmaze.shows.viewModel.ShowsViewModel
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val CoreModule = module {

    //JSON
    single { MoshiConverterFactory.create() }

    //Network
    factory<Interceptor> { HttpLoggingInterceptor() }
    single { OkHttpClientFactory.build(get(), androidContext()) }
    single { RetrofitFactory.build(BuildConfig.BASE_URL, get(), get()) }

    //Database
    single { DatabaseFactory.build(androidContext()) }

    // TVMaze API
    single { get<Retrofit>().create(ApiService::class.java) }
    factory<ApiRepository> { ApiRepositoryImpl(get()) }

    // ViewModels
    viewModel { ShowsViewModel(get()) }
}