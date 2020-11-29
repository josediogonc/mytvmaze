package com.example.mytvmaze.core.extensions

import androidx.fragment.app.Fragment

val Fragment.supportFragmentManager get() = this.requireActivity().supportFragmentManager