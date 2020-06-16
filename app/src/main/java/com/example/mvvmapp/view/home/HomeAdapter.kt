package com.example.mvvmapp.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.model.Post
import com.example.mvvmapp.util.loadCircleImage
import com.example.mvvmapp.util.loadImage
import kotlinx.android.synthetic.main.item_post.view.*

class HomeAdapter(posts: List<Post>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val posts = mutableListOf<Post>()

    init {
        this.posts.addAll(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
    )

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val post = posts[position]

        with(holder) {
            itemView.context.loadCircleImage(post.userImageUrl, userImage)
            itemView.context.loadImage(post.postImageUrl, postImage)
            userName.text = post.userName
        }
    }

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userImage: ImageView = view.user_image
        val userName: TextView = view.user_name
        val postImage: ImageView = view.post_image
    }
}