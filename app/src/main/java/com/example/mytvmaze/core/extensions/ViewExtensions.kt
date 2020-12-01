package com.example.mytvmaze.core.extensions

import android.view.View
import android.view.View.*
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation

fun View.fadeInAnimation() {
    this.visibility = VISIBLE
    this.animate().alpha(1f).setDuration(1000)
        .setInterpolator(DecelerateInterpolator()).start()
}

fun View?.rotateArrowExpand() {
    val rotate = RotateAnimation(
        360f,
        180f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    )
    rotate.duration = 300
    rotate.fillAfter = true
    this?.startAnimation(rotate)
}

fun View?.rotateArrowCollapse() {
    val rotate = RotateAnimation(
        180f,
        360f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    )
    rotate.duration = 300
    rotate.fillAfter = true
    this?.startAnimation(rotate)
}

fun View.visible() { if (this.visibility == GONE || this.visibility == INVISIBLE) this.visibility = VISIBLE }

fun View.gone() { if (this.visibility == VISIBLE || this.visibility == INVISIBLE) this.visibility = GONE }

fun View.invisible() { if (this.visibility == VISIBLE || this.visibility == GONE) this.visibility = INVISIBLE }

fun View.changeVisibility(visible: Boolean) { if (visible) this.visible() else this.gone() }

fun View.isVisible() = this.visibility == VISIBLE

fun View.disableClick() {
    this.setOnClickListener(null)
    this.isEnabled = false
}


