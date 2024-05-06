package com.example.wishlist.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(Screen.Addscreen.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable= false
                }
            )
        ){ entry ->
            val id = if (entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddScreen( viewModel = viewModel, id = 0L, navController = navController )
        }
    }
}