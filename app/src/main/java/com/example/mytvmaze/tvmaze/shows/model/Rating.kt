package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(

    @field:Json(name = "average")
    val average: Float? = null

) : Parcelable {

    override fun toString() = average?.let {
        it.toString()
    } ?: ""

}
