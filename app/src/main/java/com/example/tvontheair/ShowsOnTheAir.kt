package com.example.tvontheair

data class Show(
    val id: Int,
    val name: String,
    val poster_path: String?
)

data class ShowsOnTheAirResponse(
    val page: Int,
    val results: List<Show>,
)

data class Genre (
    val name: String
)

data class TvShowResponse (
    val backdrop_path: String?,
    val created_by: List<CreatedBy>,
    val first_air_date: String,
    val genres: List<Genre>,
    val last_air_date: String,
    val name: String,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val overview: String,
    val vote_average: Double,
    val poster_path: String?
)

data class CreatedBy (
    val name: String
)