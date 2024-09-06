package com.example.foodapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.models.Restaurant
import com.squareup.picasso.Picasso

class RestaurantAdapter(val restaurantList: List<Restaurant>, val onClick: (Restaurant) -> Unit)
    : RecyclerView.Adapter<RestaurantViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item,parent,false)
        return  RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurantList.count()
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantList[position]
        holder.restaurantTextView.text = restaurant.name
        Picasso.get().load(restaurant.image).into(holder.restaurantImage)
        holder.itemView.setOnClickListener{
            Log.i("Restaurante", restaurant.name)
            onClick(restaurant)
        }
    }

}

class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val restaurantImage : ImageView = view.findViewById(R.id.restaurant_image)
    val restaurantTextView : TextView = view.findViewById(R.id.restaurant_name)
}