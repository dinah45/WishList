package com.example.wishlist

import android.content.Context
import androidx.room.Room
import com.example.wishlist.ui.data.WishDatabase
import com.example.wishlist.ui.data.WishRespository

object Graph {
	lateinit var database: WishDatabase
	
	val wishRespository by lazy {
		WishRespository(wishDao = database.wishDao())
	}
	
	fun provide(context: Context){
		database = Room.databaseBuilder(
			context, WishDatabase::class.java,
			"wishlist.db"
		).build()
	}
	
}