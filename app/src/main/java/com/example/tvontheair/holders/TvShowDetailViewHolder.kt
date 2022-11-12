package com.example.tvontheair.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvontheair.R
import com.example.tvontheair.TvShowResponse

class TvShowDetailViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val showName_textView: TextView = itemView.findViewById(R.id.showName_textView)
    val ShowPoster: ImageView = itemView.findViewById(R.id.ShowPoster)
    val series_backdrop: ImageView = itemView.findViewById(R.id.series_backdrop)
    val showEpisodes_textView: TextView = itemView.findViewById(R.id.showEpisodes_textView)
    val overview_textView: TextView = itemView.findViewById(R.id.overview_textView)

    fun setTvShowDetail(tvShowId: TvShowResponse){
        Glide.with(ShowPoster.context).load("https://image.tmdb.org/t/p/w500" + tvShowId.poster_path).into(ShowPoster)
        Glide.with(series_backdrop.context).load("https://image.tmdb.org/t/p/w500" + tvShowId.backdrop_path).into(series_backdrop)
    }
}