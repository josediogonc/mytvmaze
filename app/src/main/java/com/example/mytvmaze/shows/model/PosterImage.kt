package com.example.mytvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PosterImage(

    @field:Json(name = "medium")
    val medium : String?,

    @field:Json(name = "original")
    val original : String?

) : Parcelable
