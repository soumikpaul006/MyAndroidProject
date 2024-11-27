package com.codegalaxy.mock21nov.model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Year


@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double,
    val year: Int,
    val cpuModel: String,
    val hardDiskSize:String
)