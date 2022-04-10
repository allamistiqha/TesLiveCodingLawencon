package com.example.teslivecodinglawencon.di

import android.app.Application
import androidx.room.Room
import com.example.teslivecodinglawencon.network.DatabaseRestoran
import com.example.teslivecodinglawencon.network.RestorantInterface
import com.example.teslivecodinglawencon.utils.Const.base_url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
   @Provides
   @Singleton
   fun provideRetrofit() : Retrofit = Retrofit.Builder()
       .baseUrl(base_url)
       .addConverterFactory(GsonConverterFactory.create())
       .build()

    @Provides
    @Singleton
    fun provideRestorantInterface(retrofit: Retrofit) : RestorantInterface
    = retrofit.create(RestorantInterface::class.java)

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): DatabaseRestoran
    = Room.databaseBuilder(app, DatabaseRestoran::class.java, "database_restoran")
        .build()
}