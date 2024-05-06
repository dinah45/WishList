package com.example.wishlist.ui.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlist.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRespository: WishRespository = Graph.wishRespository
): ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }
    
    lateinit var getAllWishes: Flow<List<Wish>>
    
    init {
    	viewModelScope.launch {
             getAllWishes = WishRespository.getAllWishes()
     }
    }
    
    fun addWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            WishRespository.addWish(wish = wish)
        }
    }
    fun getAllWishesById(id: Long): Flow<Wish> {
           return WishRespository.getAllWishesById(wish = wish)
        }
    }
    fun updateWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            WishRespository.updateAWish(wish = wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            WishRespository.deleteAWish(wish = wish)
        }
    }
