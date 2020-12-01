package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Schedule (

    @field:Json(name = "time")
    val time : String,

    @field:Json(name = "days")
    val days : List<String>

    ) : Parcelable {

        override fun toString() : String {
            val scheduleString = "$time ${days.joinToString(separator = ", ") { it } }"
            return if (scheduleString.trim().isNotEmpty()) scheduleString else "(unknown)"
        }

    }
