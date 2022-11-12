package com.example.tvontheair

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.themoviedb.org/3/tv/"
const val KEY = "86193b53da843b3ac3096b6bf0da08f4"

//Instancia de moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//consumo de api
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("on_the_air?api_key=${KEY}&language=es-es")
    fun getTvsOnTheAir(): Call<ShowsOnTheAirResponse>

    @GET("{id}?api_key=${KEY}&language=es-es")
    fun getTvShowByID(@Path("id") id: Int): Call<TvShowResponse>
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
