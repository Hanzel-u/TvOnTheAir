package com.example.tvontheair

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
)

data class Air(
    val name: String,
    val id: Int,
    val backdrop_path: String?
)

data class onTheAir(
    val page: Int,
    val results: List<Air>,
)

interface Result {
    val poster_path: String
    val popularity: Int
    val id: Int
    val backdrop_path: String
    val vote_average: Double
    val overview: String
    val first_air_date: String
}
