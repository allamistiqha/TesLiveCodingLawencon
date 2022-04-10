package com.example.teslivecodinglawencon.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.teslivecodinglawencon.data.Restoran

@Database(entities = [Restoran::class], version = 1)
abstract class DatabaseRestoran :RoomDatabase() {
    abstract fun restoranDao(): RestoranDao
}