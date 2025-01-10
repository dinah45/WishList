package com.example.wishlist.ui.data

sealed class Screen (
    val route: String
){
    object SplashScreen: Screen("splash_screen")
    object HomeScreen: Screen("home_screen")
    object Addscreen: Screen("add_screen")
}