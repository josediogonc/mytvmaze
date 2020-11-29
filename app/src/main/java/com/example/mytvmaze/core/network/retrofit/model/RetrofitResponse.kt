package com.example.mytvmaze.core.network.retrofit.model

import android.util.Log
import com.example.mytvmaze.api.model.ApiResponse
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

class RetrofitResponse<T>(
    private val request: suspend () -> Response<T>
) : ApiResponse<T> {

    override suspend fun result(): Resource<T> {
        return try {
            val response = request.invoke()
            val data = response.body()

            if (response.isSuccessful && data != null) {
                success(data)
            } else {
                error(response.code(), response.errorBody())
            }
        } catch (exception: Exception) {
            failure(exception)
        }
    }

    override fun success(data: T) = Resource.success(data)

    override fun error(code: Int, errorBody: ResponseBody?): Resource<T> {
        val error: RequestError = if (errorBody != null) {
            when (code) {
                1, //TODO
                5 -> {
                    businessLogicError(errorBody)
                }
                else -> {
                    genericError
                }
            }
        } else {
            genericError
        }
        return Resource.error(error)
    }

    override fun failure(exception: Exception): Resource<T> {
        Log.e("failure", exception.message.toString())
        return when (exception) {
            is JsonEncodingException -> {
                Resource.error(genericError)
            }

            is UnknownHostException -> {
                Resource.error(genericError)
                //Resource.error(verifyInternetConection())
            }

            is IOException -> {
                Resource.error(genericError)
                //Resource.error(verifyInternetConection())
            }

            else -> {
                Resource.error(genericError)
            }
        }
    }

    companion object {

        fun businessLogicError(errorBody: ResponseBody): RequestError {
            val moshi = Moshi.Builder().build()
            val jsonAdapter = moshi.adapter(RequestError::class.java)
            val errorObject = jsonAdapter.fromJson(errorBody.string())
            return if (errorObject == null || !errorObject.isValid()) {
                genericError
            } else {
                RequestError(
                    code = errorObject.code,
                    title = errorObject.title,
                    message = errorObject.message,
                )
            }
        }

        val genericError : RequestError
            get() = RequestError(
                code = 123, //TODO: check code
                title = "ops!",
                message = "something get wrong. check your internet connection and try again :)",
            )
    }
}