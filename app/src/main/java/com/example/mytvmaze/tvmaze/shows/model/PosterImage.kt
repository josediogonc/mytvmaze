package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class PosterImage(

    @field:Json(name = "medium")
    val medium : String,

    @field:Json(name = "original")
    val original : String

) : Parcelable, Serializable {

    override fun toString() = "{$medium, $original}"
}
