package com.example.wishlist.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.protobuf.ExperimentalApi
import com.example.wishlist.ui.data.Wish

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
            .clickable {  },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
           Text(text = wish.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
           Text(text = wish.description, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        }
    }
}