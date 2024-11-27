package com.codegalaxy.mock21nov.model.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codegalaxy.mock21nov.model.AppDatabase
import com.codegalaxy.mock21nov.model.dao.ProductDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "product_db")
            .build()
    }

    //dao
    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase):ProductDAO{
        return database.productDao()
    }

}