package com.example.mytvmaze.core

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("isVisible")
    fun showView(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}