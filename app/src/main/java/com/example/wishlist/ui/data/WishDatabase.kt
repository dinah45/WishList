package com.example.wishlist.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
	entities = [Wish::class],
	version = 1,
	exportSchema =  false
)
//@TypeConverters(Converters::class)
abstract class WishDatabase : RoomDatabase() {

	abstract fun wishDao(): WishDao

}

