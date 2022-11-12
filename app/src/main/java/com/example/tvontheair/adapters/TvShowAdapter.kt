package com.example.tvontheair.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvontheair.R
import com.example.tvontheair.Show
import com.example.tvontheair.holders.TvShowViewHolder

class TvShowAdapter(
    private val dataSet: Array<Show>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<TvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shows_on_air, parent, false)

        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val item = dataSet[position]

        holder.setTVShow(item)

        holder.itemView.setOnClickListener {
            onClick(item.id)
        }
    }

    override fun getItemCount() = dataSet.size
}