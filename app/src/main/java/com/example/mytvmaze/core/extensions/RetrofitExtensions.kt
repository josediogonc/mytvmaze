package com.example.mytvmaze.core.network.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.mytvmaze.core.network.retrofit.model.RequestError
import com.example.mytvmaze.core.network.retrofit.model.Resource
import com.example.mytvmaze.core.network.retrofit.model.RetrofitResponse
import retrofit2.Response


fun <T> Resource<T>.validateResponse(success: MutableLiveData<T>, error: MutableLiveData<RequestError>) {
    when (this.status) {
        Resource.Status.SUCCESS -> {
            this.data?.let {
                success.value = it
            }
        }
        else -> this.error?.let {
            error.value = it
        }
    }
}

suspend fun <T> Response<T>.toResource(): Resource<T> {
    return RetrofitResponse { this }.result()
}
