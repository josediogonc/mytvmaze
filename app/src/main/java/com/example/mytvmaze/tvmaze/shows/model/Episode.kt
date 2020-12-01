package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.example.mytvmaze.core.extensions.toHTML
import com.google.gson.annotations.SerializedName
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
    val summary : String?,

    @SerializedName("image")
    @field:Json(name = "image")
    val poster : PosterImage? = null,

) : Parcelable {

    override fun toString() = nameWithSeason

    val formattedSeasonAndEpisode get() = "Season $season, Episode $number"

    val formattedSummary get() = summary?.apply {
        removePrefix("<p>").removeSuffix("</p>").toHTML()
    } ?: "(Summary not found)"

    val nameWithSeason get() : String {
        val season = if(season < 10) "S0$season" else "S$season"
        val episode= if(number < 10) "E0$number" else "E$number"
        return "[$season$episode] $name"
    }
}