package com.example.tvontheair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvontheair.adapters.TvShowAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Api.retrofitService.getTvsOnTheAir().enqueue(
            object: Callback<ShowsOnTheAirResponse> {
                override fun onResponse(call: Call<ShowsOnTheAirResponse>, response: Response<ShowsOnTheAirResponse>) {
                    Log.i("Retrofit", response.body().toString())
                    response.body()?.results?.let {
                        configureTvShowsInTheAirList(it)
                    }
                }

                override fun onFailure(call: Call<ShowsOnTheAirResponse>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

    fun configureTvShowsInTheAirList(data: List<Show>) {
        val adapter = TvShowAdapter(dataSet = data.toTypedArray()) {id ->
            val intent = Intent(this, TvShowDetails::class.java)
            intent.putExtra("showId", id)
            Log.i("OnClick", "Did tap on item with id: " + id)
            startActivity(intent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = adapter
    }
}