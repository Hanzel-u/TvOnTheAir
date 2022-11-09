package com.example.tvontheair

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val dataSet: Array<Air>) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //holder.nameTextView.text = dataSet[position].name
        //holder.emailTextView.text = dataSet[position].email

        val item = dataSet[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}