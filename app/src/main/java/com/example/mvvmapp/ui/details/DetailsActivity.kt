package com.example.mvvmapp.ui.details

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvmapp.R
import com.example.mvvmapp.base.DataBindingActivity
import com.example.mvvmapp.databinding.ActivityDetailBinding
import com.example.mvvmapp.extensions.onTransformationEndContainerApplyParams
import com.example.mvvmapp.model.Pokemon
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : DataBindingActivity() {

    private val binding: ActivityDetailBinding by binding(R.layout.activity_detail)
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainerApplyParams()
        super.onCreate(savedInstanceState)

        val pokemonItem: Pokemon = requireNotNull(intent.getParcelableExtra(EXTRA_POKEMON))
        binding.apply {
            pokemon = pokemonItem
            lifecycleOwner = this@DetailsActivity
            vm = viewModel.apply { fetchPokemonInfo(pokemonItem.name) }
        }
    }

    companion object {
        private const val EXTRA_POKEMON = "EXTRA_POKEMON"

        fun startActivity(transformationLayout: TransformationLayout, pokemon: Pokemon) {
            val context = transformationLayout.context
            if (context is Activity) {
                Intent(context, DetailsActivity::class.java).apply {
                    putExtra(EXTRA_POKEMON, pokemon)
                    TransformationCompat.startActivity(transformationLayout, this)
                }
            }
        }
    }
}
