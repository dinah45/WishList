package com.example.wishlist.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wishlist.ui.components.AppBar
import com.example.wishlist.ui.components.WishTextField
import com.example.wishlist.ui.data.WishViewModel
import com.example.wishlist.R



@Composable
fun AddScreen(navController: NavController,
              id: Long,
              viewModel: WishViewModel){
    Scaffold(
        topBar = {
            AppBar(
                title =
                if (id != 0L) "Update Wish " else "Add Wish"
            ) {
                navController.navigateUp()
            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Title",
                value = viewModel.wishTitleState,
                onValueChanged = {
                    viewModel.onWishTitleChanged(it)
                })
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChanged = {
                    viewModel.onWishDescriptionChanged(it)
                })
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                if (viewModel.wishTitleState.isNotEmpty() &&
                    viewModel.wishDescriptionState.isNotEmpty()) {
// update wish
                } else {
                    }
            },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.app_color),
                    contentColor = colorResource(id = R.color.white),
                    disabledContainerColor = colorResource(id = R.color.app_color).copy(0.7f)
                )
                ) {
                Text(
                    text = if (id !=0L) "Update wish"
                    else "Add Wish",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.white)
                )
            }
        }
        }
    }