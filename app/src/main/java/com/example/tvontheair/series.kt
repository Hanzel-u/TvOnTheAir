package com.example.tvontheair

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class series : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_series, container, false)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Api.retrofitService.getTvsOnTheAir().enqueue(
            object: Callback<onTheAir> {
                override fun onResponse(call: Call<onTheAir>, response: Response<onTheAir>) {
                    Log.i("Retrofit", response.body().toString())
                    response.body()?.let {
                        //configureUsersList(it)
                        val adapter = UserAdapter(dataSet = it.results.toTypedArray())
                        val recyclerView: RecyclerView = view.findViewById(R.id.users_recyclerView)
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<onTheAir>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

}