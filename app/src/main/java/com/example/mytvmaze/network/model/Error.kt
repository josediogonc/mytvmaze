package com.example.mytvmaze.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Error(

    @field:Json(name = "code")
    val code: Int = -1,

    @field:Json(name = "title")
    val title: String = "",

    @field:Json(name = "message")
    val message: String = ""

) : Parcelable {

    fun isValid(): Boolean = code != -1 && title.isNotEmpty() && message.isNotEmpty()

}