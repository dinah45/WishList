package com.example.wishlist.ui.data

import android.app.Application
import com.example.wishlist.Graph

class WishListApp: Application() {
	override fun onCreate() {
		super.onCreate()
		Graph.provide(this)
	}
}