package com.example.tvontheair

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
    val emailTextView: TextView = itemView.findViewById(R.id.email_textView)
}