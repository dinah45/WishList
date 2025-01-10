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
@TypeConverters(Converters::class)
abstract class WishDatabase : RoomDatabase() {

	abstract fun wishDao(): WishDao

		companion object {
			@Volatile
			private var INSTANCE: WishDatabase? = null

			fun getInstance(context: Context): WishDatabase {
				return INSTANCE ?: synchronized(this) {
					val instance = Room.databaseBuilder(
						context.applicationContext,
						WishDatabase::class.java,
						"wish_database"
					)
						.addTypeConverter(CategoryTypeConverter()) // Add the Type Adapter here
						.build()
					INSTANCE = instance
					instance}
			}
		}
	}

