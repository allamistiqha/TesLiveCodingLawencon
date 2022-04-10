package com.example.teslivecodinglawencon.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teslivecodinglawencon.data.Restoran
import kotlinx.coroutines.flow.Flow

@Dao
interface RestoranDao {
   @Query("SELECT * FROM restoran")
   fun getData() : Flow<List<Restoran>>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertData(restoran: List<Restoran>)

   @Query("DELETE FROM restoran")
   suspend fun deleteAllData()
}