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
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wishlist.ui.components.AppBar
import com.example.wishlist.ui.components.WishTextField
import com.example.wishlist.ui.data.WishViewModel
import com.example.wishlist.R
import com.example.wishlist.ui.data.Wish
import kotlinx.coroutines.launch


@Composable
fun AddScreen(navController: NavController,
              id: Long,
              viewModel: WishViewModel){
    
   val snackMessage = remember {
       mutableStateOf("")
   }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    if (id != 0L) {
        val wish = viewModel.getAllWishesById(id).collectAsState(
            initial = Wish(0L, "", ""))
        viewModel.wishTitleState = wish.value.title
        viewModel.wishDescriptionState = wish.value.description
        }else {
    viewModel.wishTitleState = ""
        viewModel.wishDescriptionState = ""
    }

    Scaffold(
        topBar = {
            AppBar(
                title =
                if (id != 0L) "Update Wish " else "Add Wish"
            ) {
                navController.navigateUp()
            }
        },
        scaffoldState = scaffoldState
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
                    if (id != 0L) {
//update a wish
                        viewModel.updateWish(
                            Wish(
                                id = id,
                                title = viewModel.wishTitleState.trim(),
                                description = viewModel.wishDescriptionState.trim()
                            )
                        )
                    }else {
                    viewModel.addWish(
                        Wish(
                            title = viewModel.wishTitleState.trim(),
                            description = viewModel.wishDescriptionState.trim()
                        )
                    )
                        snackMessage.value = "Wish has been craeted"

                    }
                } else {
//                     Enter Field
                    snackMessage.value = "Enter fields to create a wish"
                    }
            },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.app_color),
                    contentColor = colorResource(id = R.color.white),
                    disabledContainerColor = colorResource(id = R.color.app_color).copy(0.7f))
                ) {
                Text(
                    text = if (id !=0L) "Update wish"
                    else "Add Wish",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.white)
                )
            }
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                navController.navigateUp()
            }
        }
        }
    }