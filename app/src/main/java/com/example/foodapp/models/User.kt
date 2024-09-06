package com.example.foodapp.models

data class User(val email : String, val password : String, val name : String){
    companion object{
        val staticUsers = listOf(
            User(email="juanfr97@hotmail.com",password = "12345", "Juan"),
            User(email="juanfr98@hotmail.com",password = "12345", "Daniel"),
            User(email="juanfr99@hotmail.com",password = "12345", "Andrea"),
            User(email="juanfr100@hotmail.com",password = "12345","Luis"),
            User(email="juanfr101@hotmail.com",password = "12345", "Armando"),
        )
    }
}