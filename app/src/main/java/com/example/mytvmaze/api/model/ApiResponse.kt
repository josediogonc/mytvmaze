package com.example.mytvmaze.api.model

import com.example.mytvmaze.core.network.retrofit.model.Resource
import okhttp3.ResponseBody

interface ApiResponse<T> {
    suspend fun result(): Resource<T>
    fun success(data: T): Resource<T>
    fun error(code: Int, errorBody: ResponseBody?): Resource<T>
    fun failure(exception: Exception): Resource<T>
}