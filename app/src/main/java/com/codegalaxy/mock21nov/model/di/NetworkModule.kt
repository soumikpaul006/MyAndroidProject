package com.codegalaxy.mock21nov.model.di

import android.content.Context
import com.codegalaxy.mock21nov.NetworkConnectionInterceptor
import com.codegalaxy.mock21nov.model.remote.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

//    @Provides
//    @Singleton
//    fun provideNetworkConnectionInterceptor(context: Context): NetworkConnectionInterceptor {
//        return NetworkConnectionInterceptor(context)
//    }

    @Provides
    @Singleton
    fun provideOkhttp(httpLoggingInterceptor: HttpLoggingInterceptor
                      ,networkConnectionInterceptor: NetworkConnectionInterceptor
    ): OkHttpClient {
        val client= OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(networkConnectionInterceptor)
            .build()

        return client
    }

    @Provides
    @Singleton
    @Named("retrofit1")
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl("https://api.restful-api.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("retrofit2")
    fun provideRetrofit2(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl("https://jsonplaceholder.typicode.com/todos/1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideProductApi(@Named("retrofit1") retrofit: Retrofit):ProductApi{
        return retrofit.create(ProductApi::class.java)
    }

}