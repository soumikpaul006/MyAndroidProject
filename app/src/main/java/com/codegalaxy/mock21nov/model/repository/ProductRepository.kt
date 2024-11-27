package com.codegalaxy.mock21nov.model.repository

import com.codegalaxy.mock21nov.model.Entity.ProductEntity
import com.codegalaxy.mock21nov.model.dao.ProductDAO
import com.codegalaxy.mock21nov.model.dto.ProductRequest
import com.codegalaxy.mock21nov.model.dto.ProductResponse
import com.codegalaxy.mock21nov.model.remote.ProductApi
import javax.inject.Inject


class ProductRepository @Inject constructor(

    private val productApi: ProductApi,
    private val productDAO: ProductDAO

):IProductRepository {


    //postProduct to the server
    override suspend fun postProduct(productRequest: ProductRequest):ProductResponse
    {
        return productApi.postProduct(productRequest)
    }

    //save product in room
    override suspend fun saveProduct(productEntity: ProductEntity){
        productDAO.insertProduct(productEntity)
    }

    //check the product exist or not
    override suspend fun checkProduct(name:String):ProductEntity?{
        return productDAO.getProductByName(name)
    }

    override suspend fun fetchProductsByIds(ids: List<String>): List<ProductResponse> {
        return productApi.getProductsByIds(ids)
    }
}