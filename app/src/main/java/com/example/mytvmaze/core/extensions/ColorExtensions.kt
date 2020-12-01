package com.example.mytvmaze.core.extensions

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mytvmaze.R

fun Context.getResourceColor(@ColorRes id : Int) = ContextCompat.getColor(this, id)

infix fun Fragment.getColor(@ColorRes id : Int) = requireContext().getResourceColor(id)
