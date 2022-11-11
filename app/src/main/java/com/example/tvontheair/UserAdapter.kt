package com.example.tvontheair

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val dataSet: Array<Air>,
    private val onTap: (String) -> Unit
    ) : RecyclerView.Adapter<UserViewHolder>() {

    lateinit var startButton: Button

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)

        startButton = view.findViewById(R.id.start_button)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //holder.nameTextView.text = dataSet[position].name
        //holder.emailTextView.text = dataSet[position].email

        val item = dataSet[position]
        holder.render(item)

        // Invocamos la clase Nav Direction con la acción correspondiente.
        //val action = RegistrationFragmentDirections.actionRegistrationFragmentToVerifyFragment(carnet = carnet, phone = phone);

        // Navegamos a la acción.
        //it.findNavController().navigate(action)

        startButton.setOnClickListener {
            //val action = item.name //UserAdapterDirections.actionUserAdapterToTvDetailFragment()
            //it.findNavController().n avigate(R.id.action_series_to_tvDetailFragment)
            //onTap(item.name)
            Log.i("Retrofit tocaste: ", item.name)
            //it.findNavController().navigate(R.id.action_series_to_tvDetailFragment)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}