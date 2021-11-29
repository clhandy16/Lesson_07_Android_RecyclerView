package com.example.lesson_07_android_recyclerview.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_07_android_recyclerview.R
import com.example.lesson_07_android_recyclerview.data.PlaceListAdapter.*

class PlaceListAdapter(private val list:ArrayList<Place>, private val context: Context): RecyclerView.Adapter<viewHolder>() {
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bindItem(list[position])
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class viewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(place:Place) {
            var country:TextView = itemView.findViewById(R.id.country_ID) as TextView
            var city:TextView = itemView.findViewById(R.id.city_ID) as TextView
            country.text = place.CountryName
            city.text = place.CityName
            itemView.setOnClickListener{Toast.makeText(context, country.text, Toast.LENGTH_SHORT).show()}
        }
    }

}