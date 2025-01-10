package com.example.wishlist.ui.screen

import android.graphics.drawable.Icon
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlist.R
import com.example.wishlist.ui.components.AppBar
import com.example.wishlist.ui.components.WishItem
import com.example.wishlist.ui.data.DummyWish
import com.example.wishlist.ui.data.Screen
import com.example.wishlist.ui.data.WishViewModel


@Composable
fun HomeScreen(navController: NavController,
               viewModel: WishViewModel
    ) {
    val context = LocalContext.current
    Column(
modifier = Modifier
    .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Scaffold(
            topBar = {
                AppBar(title = "Wish List", {

                })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.Addscreen.route + "/0L")
                    },
                    modifier = Modifier
                        .padding(20.dp),
                    contentColor = Color.White,
                    backgroundColor = colorResource(id = R.color.app_color)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                }
            }
        ) {
            val wishlist = viewModel.getAllWishes.collectAsState(
                initial = listOf()
            )
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .wrapContentSize()
            ) {
                items(wishlist.value, key = { wish -> wish.id }) {
                    wish ->
                    val dismissState = rememberDismissState(
                        confirmStateChange = {
                            if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart){
                                viewModel.deleteWish(wish)
                            }
                            true
                        }
                    )
                    androidx.compose.material3.SwipeToDismiss(
                        state = dismissState,
                        background = {
                            var color by animateColorAsState(
                                if (dismissState.dismissDirection == DismissDirection.EndToStart)
                                    Color.Red else Color.Transparent,
                                label = ""
                            )
                            val alignment = Alignment.CenterEnd
                            Box(Modifier.fillMaxSize().background(color).padding(horizontal = 20
                                .dp),
                                contentAlignment = alignment
                            ){
                                androidx.compose.material.Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }
                        }.
                        directions = setOf(DismissDirection.StartToEnd, DismissDirection
                            .EndToStart),
                        dismissThresholds = { FractionalThreshold(0.23f) },
                        dismissContent = {
                            WishItem(wish = wish)
                        }

                    ) {

                    }

                    WishItem(wish = wish) {

                    }
                }
            }
        }
    }
}