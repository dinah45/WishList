package com.example.wishlist.ui.data

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name =  "wish-title")
    val title: String = "",
    @ColumnInfo(namer = "wish-desc")
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