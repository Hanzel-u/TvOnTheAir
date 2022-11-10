package com.example.tvontheair

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class series : Fragment() {

    //lateinit var startButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_series, container, false)

        //startButton = view.findViewById(R.id.start_button)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        startButton.setOnClickListener {
//            it.findNavController().navigate(R.id.action_series_to_tvDetailFragment)
//        }

        Api.retrofitService.getTvsOnTheAir().enqueue(
            object: Callback<onTheAir> {
                override fun onResponse(call: Call<onTheAir>, response: Response<onTheAir>) {
                    Log.i("Retrofit", response.body().toString())
                    response.body()?.let {
                        //configureUsersList(it)
                        val adapter = UserAdapter(dataSet = it.results.toTypedArray()) { name ->
                            val action = seriesDirections.actionSeriesToTvDetailFragment(name)
                            view.findNavController().navigate(action)
                        }
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