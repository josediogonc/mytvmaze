package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowsResponse(

    @SerializedName("score")
    val score : Float,

    @SerializedName("show")
    val show : Show,

) : Parcelable