package com.example.mvvmapp.binding

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity.CENTER
import android.view.View
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.example.mvvmapp.extensions.gone
import com.github.florent37.glidepalette.BitmapPalette.Profile.MUTED_LIGHT
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.card.MaterialCardView
import com.skydoves.androidribbon.RibbonRecyclerView
import com.skydoves.androidribbon.ribbonView
import com.skydoves.progressview.ProgressView
import com.skydoves.rainbow.Rainbow
import com.skydoves.rainbow.RainbowOrientation
import com.skydoves.rainbow.color
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("toast")
fun bindToast(view: View, text: LiveData<String>) {
    text.value.whatIfNotNull {
        Toast.makeText(view.context, it, LENGTH_SHORT).show()
    }
}

@BindingAdapter("paletteImage", "paletteCard")
fun bindLoadImagePalette(view: AppCompatImageView, url: String, paletteCard: MaterialCardView) {
    Glide.with(view.context)
        .load(url)
        .listener(GlidePalette.with(url)
            .use(MUTED_LIGHT)
            .intoCallBack { palette ->
                palette?.dominantSwatch?.rgb?.let {
                    paletteCard.setCardBackgroundColor(it)
                }
            }
            .crossfade(true))
        .into(view)
}

@BindingAdapter("paletteImage", "paletteView")
fun bindLoadImagePaletteView(view: AppCompatImageView, url: String, paletteView: View) {
    val context = view.context
    Glide.with(context)
        .load(url)
        .listener(
            GlidePalette.with(url)
                .use(MUTED_LIGHT)
                .intoCallBack { palette ->
                    palette?.dominantSwatch?.rgb?.let { domain ->
                        val light = palette.lightVibrantSwatch?.rgb
                        if (light != null) {
                            Rainbow(paletteView).palette {
                                +color(domain)
                                +color(light)
                            }.background(orientation = RainbowOrientation.TOP_BOTTOM)
                        } else {
                            paletteView.setBackgroundColor(domain)
                        }
                        if (context is AppCompatActivity) {
                            context.window.apply {
                                addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                                statusBarColor = domain
                            }
                        }
                    }
                }.crossfade(true)
        )
        .into(view)
}

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) = view.gone(shouldBeGone)

@BindingAdapter("onBackPressed")
fun bindOnBackPressed(view: View, finish: Boolean) {
    val context = view.context
    if (finish && context is Activity) {
        view.setOnClickListener {
            context.onBackPressed()
        }
    }
}

@BindingAdapter("bindPokemonTypes")
fun bindPokemonTypes(recyclerView: RibbonRecyclerView, types: List<PokemonInfo.TypeResponse>?) {
    types.whatIfNotNullOrEmpty {
        recyclerView.clear()
        for (type in it) {
            with(recyclerView) {
                addRibbon(
                    ribbonView(context) {
                        setText(type.type.name)
                        setTextColor(Color.WHITE)
                        setPaddingLeft(84f)
                        setPaddingRight(84f)
                        setPaddingTop(2f)
                        setPaddingBottom(10f)
                        setTextSize(16f)
                        setRibbonRadius(120f)
                        setTextStyle(Typeface.BOLD)
                        setRibbonBackgroundColorResource(
                            PokemonTypeUtils.getTypeColor(type.type.name)
                        )
                    }.apply {
                        maxLines = 1
                        gravity = CENTER
                    }
                )
                addItemDecoration(SpacesItemDecoration())
            }
        }
    }
}

@BindingAdapter("progressView_labelText")
fun bindProgressViewLabelText(progressView: ProgressView, text: String?) {
    progressView.labelText = text
}

@BindingAdapter("progressView_progress")
fun bindProgressViewProgress(progressView: ProgressView, value: Int?) {
    value?.let {
        progressView.progress = it.toFloat()
    }
}

@BindingAdapter("progressView_max")
fun bindProgressViewMax(progressView: ProgressView, value: Int?) {
    value?.let {
        progressView.max = it.toFloat()
    }
}
