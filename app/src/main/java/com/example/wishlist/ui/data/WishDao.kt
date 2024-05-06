package com.example.wishlist.ui.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
 interface WishDao {
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun addAWish(wish: Wish)
	
//	Loads all wishes from the wish table
	@Query("Select * from 'wish-table'")
	 fun getAllWishes(wish: Wish): Flow<List<Wish>>
	
	@Update
	 suspend fun updateAWish (wish: Wish)
	
	@Delete
	 suspend fun deleteAWish (wish: Wish)
	
	@Query("Select * from 'wish-table' where id=:id")
	 fun getAWishById (id:Long): Flow<Wish>
}