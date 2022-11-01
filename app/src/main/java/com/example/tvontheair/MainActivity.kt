package com.example.tvontheair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
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

        Api.retrofitService.getUsers().enqueue(
            object: Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    Log.i("Retrofit", response.body().toString())

                    response.body()?.let {
                        configureUsersList(it)
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

    fun configureUsersList(data: List<User>) {
        val adapter = UserAdapter(dataSet = data.toTypedArray())

        val recyclerView: RecyclerView = findViewById(R.id.users_recyclerView)

        recyclerView.adapter = adapter
    }
}