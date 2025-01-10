package com.example.wishlist.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wishlist.R
import com.example.wishlist.ui.data.WishViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController,
                 viewModel: WishViewModel
    ) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
navController.navigate("home_screen")    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.app_color)),
        contentAlignment = Alignment.Center
    ){
        Text("Wish List",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }

}