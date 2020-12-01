package com.example.mytvmaze.core

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageFactory {

    fun load(url: String?, view: ImageView) = Picasso.get().load(url).into(view)
}