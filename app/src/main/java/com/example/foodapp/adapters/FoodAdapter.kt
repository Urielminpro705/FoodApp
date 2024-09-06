package com.example.foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.models.Food
import com.squareup.picasso.Picasso

class FoodAdapter(val foodList : List<Food>)
    : RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return  FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.count()
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodTV.text = food.name
        Picasso.get().load(food.image).into(holder.foodImage)
    }

}

class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val foodImage : ImageView = view.findViewById(R.id.food_image)
    val foodTV : TextView = view.findViewById(R.id.food_name)
}