package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mytvmaze.core.extensions.toHTML
import com.example.mytvmaze.database.*
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Show(

    @PrimaryKey
    @field:Json(name = "id")
    val id : Int,

    @field:Json(name = "name")
    val name : String,

    @TypeConverters(PosterImageConverter::class)
    @SerializedName("image")
    @field:Json(name = "image")
    val poster : PosterImage,

    @TypeConverters(GenresConverter::class)
    @field:Json(name = "genres")
    val genres : List<String> = emptyList(),

    @field:Json(name = "status")
    val status : String,

    @field:Json(name = "type")
    val type : String,

    @field:Json(name = "premiered")
    val premiered : String,

    @TypeConverters(RatingConverter::class)
    @field:Json(name = "rating")
    val rating : Rating,

    @TypeConverters(ScheduleConverter::class)
    @field:Json(name = "schedule")
    val schedule : Schedule,

    @field:Json(name = "summary")
    val summary : String,

    @TypeConverters(NetworkConverter::class)
    @field:Json(name = "network")
    val network : Network? = null,

) : Parcelable {

    val genresAsString get() = if (genres.isNotEmpty()) {
        genres.joinToString(separator = " / ") { it }
    } else {
        "(Unknown genre)"
    }

    val formattedSummary get() = summary.removePrefix("<p>").removeSuffix("</p>").toHTML()
}