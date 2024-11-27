package com.codegalaxy.mock21nov.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codegalaxy.mock21nov.model.Entity.ProductEntity

@Dao
interface ProductDAO {

    //INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product:ProductEntity)

    //FETCH
    @Query("SELECT * FROM PRODUCTS WHERE name= :name")
    suspend fun getProductByName(
        name:String
    ):ProductEntity
}