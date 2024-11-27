package com.codegalaxy.mock21nov.model.di

import com.codegalaxy.mock21nov.model.repository.ProductRepository
import com.codegalaxy.mock21nov.model.dao.ProductDAO
import com.codegalaxy.mock21nov.model.remote.ProductApi
import com.codegalaxy.mock21nov.model.repository.IProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

//    @Provides
//    @Singleton
//    fun provideProductRepository(
//        api: ProductApi,
//        dao: ProductDAO
//    ): IProductRepository {
//        return ProductRepository(api,dao)
//    }


    //when we are injecting interface we need to use bind
    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepository: ProductRepository
    ): IProductRepository

}