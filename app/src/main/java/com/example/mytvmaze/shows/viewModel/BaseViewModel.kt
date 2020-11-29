package com.example.mytvmaze.shows.viewModel

import androidx.lifecycle.ViewModel
import com.example.mytvmaze.network.api.ApiRepository

open class BaseViewModel(protected val apiRepository: ApiRepository) : ViewModel() {
}