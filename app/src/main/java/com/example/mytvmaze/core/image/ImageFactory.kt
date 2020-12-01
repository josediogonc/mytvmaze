package com.example.mytvmaze.core.image

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageFactory {

    fun load(url: String?, placeHolderId: Int, view: ImageView) = Picasso.get().load(url).placeholder(placeHolderId).into(view)
}