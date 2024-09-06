package com.example.foodapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.adapters.FoodAdapter
import com.example.foodapp.models.Food
import com.example.foodapp.models.Restaurant

class RestaurantActivity : AppCompatActivity() {
    lateinit var restaurantTV : TextView
    lateinit var foodRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_restaurant)
        restaurantTV = findViewById(R.id.restaurant_activity_name)
        foodRecyclerView = findViewById(R.id.foods_activity_recyclerview)


        val restaurantId = intent.getIntExtra("restaurantId", 0)
        Log.i("RestaurantActivity","El Id es ${restaurantId.toString()}")
        val restaurant = Restaurant.restaurants.firstOrNull{it.id == restaurantId}
        Log.i("El restaurante",restaurant.toString())
        val foods = Food.foods.filter { it.restaurantId == restaurantId }
        restaurantTV.text = restaurant?.name
        foodRecyclerView.adapter = FoodAdapter(foods)
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}