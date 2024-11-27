package com.codegalaxy.mock21nov.model


import androidx.room.Database
import androidx.room.RoomDatabase
import com.codegalaxy.mock21nov.model.Entity.ProductEntity
import com.codegalaxy.mock21nov.model.dao.ProductDAO


@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao():ProductDAO
}