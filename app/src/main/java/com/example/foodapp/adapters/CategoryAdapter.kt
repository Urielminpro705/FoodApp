package com.example.foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.models.Category
import com.squareup.picasso.Picasso

class CategoryAdapter(val categories : List<Category>) : RecyclerView.Adapter<CategoryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return  CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryTextView.text = category.name
        Picasso.get().load(category.image).into(holder.categoryImage)
    }

}

class CategoryViewHolder(view:View) : RecyclerView.ViewHolder(view){
    val categoryImage : ImageView = view.findViewById(R.id.category_image)
    val categoryTextView : TextView = view.findViewById(R.id.category_name)
}