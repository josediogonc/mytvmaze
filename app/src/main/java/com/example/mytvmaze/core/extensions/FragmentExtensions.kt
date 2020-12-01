package com.example.mytvmaze.core.extensions

import android.content.Context
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

val Fragment.supportFragmentManager get() = this.requireActivity().supportFragmentManager

fun FragmentActivity.hideSoftInput() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(this.window.decorView.windowToken, 0)
}

fun Fragment.hideSoftInput() =  requireActivity().hideSoftInput()

fun FragmentActivity.showSoftInput(view : View) {
    Handler().postDelayed( {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.showSoftInput(view, 0)
    }, 200)

}

fun Context.showSoftInput(view : View) {
    Handler().postDelayed( {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.showSoftInput(view, 0)
    }, 200)

}

fun Fragment.showSoftInput(view : View) = requireActivity().showSoftInput(view)