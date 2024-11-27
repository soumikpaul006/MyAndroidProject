package com.codegalaxy.mock21nov.model.repository

import com.codegalaxy.mock21nov.model.Entity.ProductEntity
import com.codegalaxy.mock21nov.model.dto.ProductRequest
import com.codegalaxy.mock21nov.model.dto.ProductResponse

interface IProductRepository {

    suspend fun checkProduct(name:String):ProductEntity?

    suspend fun postProduct(productRequest: ProductRequest):ProductResponse

    suspend fun saveProduct(productEntity: ProductEntity)

    suspend fun fetchProductsByIds(ids: List<String>): List<ProductResponse>

}