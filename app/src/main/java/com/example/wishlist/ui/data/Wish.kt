package com.example.wishlist.ui.data

import android.icu.text.CaseMap.Title

data class Wish (
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch", description = "lastest Apple Watch"),
        Wish(title = "Iphone", description = "lastest Iphone"),
        Wish(title = "Bags",description = "Blue, Black, Red HandBags"),
        Wish(title = "Shoes",description = "Black, White, Red Shoes"),
        Wish(title = "Google Watch",description = "lastest Apple Watch")
    )
}