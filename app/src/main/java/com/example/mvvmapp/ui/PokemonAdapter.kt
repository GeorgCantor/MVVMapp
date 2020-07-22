package com.example.mvvmapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.databinding.ItemPokemonBinding
import com.example.mvvmapp.model.Pokemon
import com.example.mvvmapp.ui.details.DetailsActivity

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private val items: MutableList<Pokemon> = mutableListOf()
    private var onClickedTime = System.currentTimeMillis()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPokemonBinding>(
            inflater,
            R.layout.item_pokemon,
            parent,
            false
        )
        return PokemonViewHolder(binding)
    }

    fun addPokemonList(pokemonList: List<Pokemon>) {
        items.addAll(pokemonList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            pokemon = item
            executePendingBindings()
            root.setOnClickListener {
                val currentTime = System.currentTimeMillis()
                if (currentTime - onClickedTime > transformationLayout.duration) {
                    onClickedTime = currentTime
                    DetailsActivity.startActivity(transformationLayout, item)
                }
            }
        }
    }

    override fun getItemCount() = items.size

    class PokemonViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)
}
