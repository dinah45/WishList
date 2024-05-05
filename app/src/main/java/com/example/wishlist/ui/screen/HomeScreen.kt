package com.example.wishlist.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.example.wishlist.R
import com.example.wishlist.ui.components.AppBar
import com.example.wishlist.ui.components.WishItem
import com.example.wishlist.ui.data.DummyWish
import com.example.wishlist.ui.data.WishViewModel
import com.example.wishlist.ui.screen.destinations.AddScreenDestination


@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator,
               viewModel: WishViewModel
    ){
    val context = LocalContext.current

    Scaffold (
        topBar = {
            AppBar(title = "Wish List",{

        })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigator.navigate("AddScreen")
            },
                modifier = Modifier
                    .padding(20.dp),
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.app_color)
                ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }

    ){
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .wrapContentSize()
        ){
items(DummyWish.wishList){
    wish -> WishItem(wish = wish) {
    
}
}
        }
    }
}