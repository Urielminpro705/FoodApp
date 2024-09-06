package com.example.foodapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.MainActivity
import com.example.foodapp.R
import com.example.foodapp.adapters.CategoryAdapter
import com.example.foodapp.adapters.FoodAdapter
import com.example.foodapp.adapters.RestaurantAdapter
import com.example.foodapp.models.Category
import com.example.foodapp.models.Food
import com.example.foodapp.models.Restaurant
import com.example.foodapp.models.User

class HomeActivity : AppCompatActivity() {
    lateinit var username : TextView
    lateinit var logoutBtn : ImageView
    lateinit var categoriesRecyclerView : RecyclerView
    lateinit var restaurantRecyclerView : RecyclerView
    lateinit var foodRecyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val userEmail = sharedPreferences.getString("userEmail","")
        val user = User.staticUsers.firstOrNull{ user -> user.email == userEmail }
        username = findViewById(R.id.usernameTV)
        logoutBtn = findViewById(R.id.logoutBtn)
        categoriesRecyclerView = findViewById(R.id.categories_recycleview)
        restaurantRecyclerView = findViewById(R.id.restaurants_recyclerview)
        foodRecyclerView = findViewById(R.id.foods_recyclerview)

        username.text = user?.name

        categoriesRecyclerView.adapter = CategoryAdapter(Category.categories)
        categoriesRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        restaurantRecyclerView.adapter = RestaurantAdapter(Restaurant.restaurants) { restaurant ->
            Log.i("HomeActivityRestaurant", restaurant.name)
            val intent = Intent(this@HomeActivity, RestaurantActivity::class.java).apply{
                putExtra("restaurantId",restaurant.id)
            }

            startActivity(intent)
        }
        restaurantRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        foodRecyclerView.adapter = FoodAdapter(Food.foods)
        foodRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        logoutBtn.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}