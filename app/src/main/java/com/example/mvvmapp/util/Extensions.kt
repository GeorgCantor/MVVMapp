package com.example.mvvmapp.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmapp.R

fun Context.loadImage(url: String, view: ImageView) = Glide.with(this)
    .load(url)
    .placeholder(R.drawable.ic_launcher_background)
    .thumbnail(0.1F)
    .into(view)

fun Context.loadCircleImage(url: String, view: ImageView) = Glide.with(this)
    .load(url)
    .circleCrop()
    .placeholder(R.drawable.ic_launcher_background)
    .thumbnail(0.1F)
    .into(view)