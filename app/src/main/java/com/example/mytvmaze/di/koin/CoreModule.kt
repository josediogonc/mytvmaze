package com.example.mytvmaze.di.koin

import org.koin.dsl.module
import com.example.mytvmaze.BuildConfig
import com.example.mytvmaze.network.api.ApiRepository
import com.example.mytvmaze.network.api.ApiRepositoryImpl
import com.example.mytvmaze.network.api.ApiService
import com.example.mytvmaze.network.retrofit.OkHttpClientFactory
import com.example.mytvmaze.network.retrofit.RetrofitFactory
import com.example.mytvmaze.shows.viewModel.ShowsViewModel
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

    // TVMaze API
    single { get<Retrofit>().create(ApiService::class.java) }
    factory<ApiRepository> { ApiRepositoryImpl(get()) }

    // ViewModels
    viewModel { ShowsViewModel(get()) }
}