package com.example.mytvmaze.shows.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ShowsResponse(

    @SerializedName("score")
    val score : Float,

    @SerializedName("show")
    val show : Show,

) : Parcelable