package com.example.wishlist.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlist.ui.data.Screen
import com.example.wishlist.ui.data.WishViewModel

@Composable
fun Navigation(viewModel: WishViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
               navController: NavHostController = rememberNavController()){
    NavHost(navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route){
            SplashScreen( viewModel = viewModel, navController = navController )
        }
        composable(Screen.HomeScreen.route){
            HomeScreen( viewModel = viewModel, navController = navController )
        }
        composable(Screen.Addscreen.route){
            AddScreen( viewModel = viewModel, id = 0L, navController = navController )
        }
//        composable(Screen.SplashScreen.route){
//            SplashScreen( viewModel = viewModel, navController = navController )
//        }
    }
}