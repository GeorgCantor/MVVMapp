package com.example.mvvmapp.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.model.Post
import com.example.mvvmapp.util.loadCircleImage
import kotlinx.android.synthetic.main.item_post.view.*

class HomeAdapter(posts: List<Post>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val posts = mutableListOf<Post>()

    init {
        this.posts.addAll(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val post = posts[position]

        with(holder) {
            itemView.context.loadCircleImage(post.userImageUrl, userImage)
            recyclerView.adapter = NestedAdapter(post.postImages)
            userName.text = post.userName
            likesCounter.text = post.likes.toString()
            postName.text = post.userName
            postDescription.text = post.postDescription
        }
    }

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userImage: ImageView = view.user_image
        val userName: TextView = view.user_name
        val recyclerView: RecyclerView = view.image_recycler
        val likesCounter: TextView = view.likes_counter
        val postName: TextView = view.post_name
        val postDescription: TextView = view.post_description
    }
}