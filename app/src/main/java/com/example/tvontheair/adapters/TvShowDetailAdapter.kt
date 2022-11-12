package com.example.tvontheair.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvontheair.R
import com.example.tvontheair.TvShowResponse
import com.example.tvontheair.holders.TvShowDetailViewHolder

class TvShowDetailAdapter (
    private val dataSet: TvShowResponse
) : RecyclerView.Adapter<TvShowDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_show_details_item, parent, false)

        return TvShowDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowDetailViewHolder, position: Int) {
        val item = dataSet

        holder.setTvShowDetail(item)
        holder.showName_textView.text = dataSet.name
        holder.showEpisodes_textView.text = dataSet.number_of_episodes.toString()
        holder.overview_textView.text = dataSet.overview

        var genre = ""
        for (i in dataSet.genres.indices) {
            genre += dataSet.genres[i].name
            if (i != dataSet.genres.size - 1) {
                genre += ", "
            }
        }

        holder.genre_textView.text = genre
    }

    override fun getItemCount(): Int {
        return 1
    }
}