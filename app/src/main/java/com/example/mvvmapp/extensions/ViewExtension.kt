package com.example.mvvmapp.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.gone(shouldBeGone: Boolean) {
    visibility = if (shouldBeGone) GONE else VISIBLE
}
