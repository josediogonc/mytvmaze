package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import android.util.Log
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Schedule (

    @field:Json(name = "time")
    val time : String,

    @field:Json(name = "days")
    val days : List<String>

    ) : Parcelable {

    init {
        toString()
    }

        override fun toString() : String {
            val a = "{$time $days}"
            Log.d("Schedule", a)
            return a
        }
    }
