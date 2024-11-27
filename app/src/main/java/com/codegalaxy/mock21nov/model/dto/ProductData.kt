package com.codegalaxy.mock21nov.model.dto

import com.google.gson.annotations.SerializedName

data class ProductData(
    val year: Int,
    val price: Double,
    @SerializedName("CPU model") val cpuModel: String,
    @SerializedName("Hard disk size") val hardDiskSize: String
)