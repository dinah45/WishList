package com.example.wishlist.ui.components

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {
    @TypeConverter
    fun fromWishEntity(wishEntity: Wish): String {
        return wishEntity
        // Convert the WishEntity object into a string that can be stored in the database.
    }

    @TypeConverter
    fun toWishEntity(string: String): Wish {
    return wishEntity
        // Convert the string back into a WishEntity object.
    }
    @TypeConverter
    fun fromCategory(category: Category): String {
        return category.name
    }

    @TypeConverter
    fun toCategory(name: String): Category {
        return Category.valueOf(name)
    }
}


//@TypeConverter
//fun stringToBigDecimal(value: String): BigDecimal {
//    return BigDecimal(value)
//}
