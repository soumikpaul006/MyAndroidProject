package com.codegalaxy.mock21nov.model.remote

import com.codegalaxy.mock21nov.model.dto.ProductRequest
import com.codegalaxy.mock21nov.model.dto.ProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductApi {

    @POST("objects")
    suspend fun postProduct(
        @Body product: ProductRequest
    ):ProductResponse


    @GET("objects")
    suspend fun getProductsByIds(
        @Query("id") ids: List<String>
    ): List<ProductResponse>

}