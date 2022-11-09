package com.example.tvontheair

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
    val image: ImageView = itemView.findViewById(R.id.backdrop_path_imageView)

    fun render(user: Air) {
        nameTextView.text = user.name
        Glide.with(image.context).load("https://image.tmdb.org/t/p/original" + user.backdrop_path).into(image)

        nameTextView.setOnClickListener { Toast.makeText(nameTextView.context, user.name, Toast.LENGTH_SHORT).show() }
    }
}