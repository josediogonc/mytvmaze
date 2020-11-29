package com.example.mytvmaze.shows.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject
import java.io.Serializable

@Parcelize
data class Show(

    @field:Json(name = "id")
    val id : Int,

    @field:Json(name = "name")
    val name : String,

    @SerializedName("image")
    @field:Json(name = "image")
    val poster : PosterImage?,

    @field:Json(name = "genres")
    val genres : List<String>

) : Parcelable