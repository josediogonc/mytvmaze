package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Episode(

    @field:Json(name = "id")
    val id : Int,

    @field:Json(name = "name")
    val name : String,

    @field:Json(name = "season")
    val season : Int,

    @field:Json(name = "number")
    val number : Int,

    @field:Json(name = "summary")
    val summary : String,

    @field:Json(name = "image")
    val poster : PosterImage,

) : Parcelable