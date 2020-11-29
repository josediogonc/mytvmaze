package com.example.mytvmaze.shows.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytvmaze.network.api.ApiRepository
import com.example.mytvmaze.network.model.Error
import com.example.mytvmaze.network.model.Resource
import com.example.mytvmaze.shows.model.ShowsResponse
import kotlinx.coroutines.launch


class ShowsViewModel(apiRepository: ApiRepository) : BaseViewModel(apiRepository) {

    val loading = MutableLiveData<Boolean>()
    val showList = MutableLiveData<List<ShowsResponse>>()

    private val _errorDialog = MutableLiveData<Error>()
    val errorDialog: LiveData<Error> = _errorDialog

/*    fun getShows2() {
        val call = apiRepository.getShows("django")

        call.enqueue(object : retrofit2.Callback<List<ShowsResponse>> {
            override fun onResponse(
                call: Call<List<ShowsResponse>>,
                response: Response<List<ShowsResponse>>
            ) {
                val list = response.body();
                showList.value = list
            }

            override fun onFailure(call: Call<List<ShowsResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }*/

    fun getShows() {
        viewModelScope.launch {
            loading(true)
            val resource = apiRepository.getShows("alice")

            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    resource.data?.let { showsResponse ->
                        showList.value = showsResponse
                        Log.d("ShowsViewModel()", " SUCCESS -> " + showList.value.toString())
                    }
                }
                Resource.Status.ERROR -> {
                    Log.d("ShowsViewModel()", " ERROR -> " + showList.value.toString())
                    _errorDialog.value = resource.error
                }
            }
        }

    }

    fun loading(value: Boolean) {
        loading.value = value
    }

}