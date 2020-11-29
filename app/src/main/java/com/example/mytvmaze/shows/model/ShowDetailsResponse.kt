package com.example.mytvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowDetailsResponse (

    @field:Json(name = "id")
    val id : Int,

    @field:Json(name = "name")
    val name : String,

    @field:Json(name = "image")
    val poster : PosterImage,

    @field:Json(name = "genres")
    val genres : List<String>,

    @field:Json(name = "language")
    val language : String,

    @field:Json(name = "summary")
    val summary : String,

    @field:Json(name = "officialSite")
    val officialSite : String,

    ) : Parcelable