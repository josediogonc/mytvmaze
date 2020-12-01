package com.example.mytvmaze.tvmaze.shows.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Network (

    @field:Json(name = "name")
    val name : String? = null

) : Parcelable {

    override fun toString() = this.name?.let { it } ?: "(unknown)"

}