package com.example.tvontheair

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tvontheair.adapters.TvShowDetailAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowDetails : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_tv_show_details)

            Log.i("TvShowDetails", "onCreate ENTRE")

            val intent : Intent = getIntent()
            val show = intent.getIntExtra("showId", 0)

            ShowClicked.show_id = show

        }

        override fun onResume() {
            super.onResume()
            Log.i("TvShowDetails", "el valor de show_id es: " + ShowClicked.show_id)
            Api.retrofitService.getTvShowByID(ShowClicked.show_id).enqueue(
                object: Callback<TvShowResponse> {
                    override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                        Log.i("Retrofit success", response.body().toString())

                        response.body()?.let {
                            configureTvShow(it)
                        }

                    }

                    override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                        Log.i("error_TvShowDetails", t.message.toString())
                    }
                }
            )
        }

        fun configureTvShow(data: TvShowResponse) {
            val adapter = TvShowDetailAdapter(dataSet = data)

            val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)

            recyclerView.adapter = adapter
        }

}