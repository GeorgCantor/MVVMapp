package com.example.mvvmapp.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.util.loadImage
import kotlinx.android.synthetic.main.item_post_image.view.*

class NestedAdapter(urls: List<String>) : RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {

    private val urls = mutableListOf<String>()

    init {
        this.urls.addAll(urls)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NestedViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_post_image, parent, false)
    )

    override fun getItemCount() = urls.size

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        val url = urls[position]
        holder.itemView.context.loadImage(url, holder.image)
    }

    class NestedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.image
    }
}