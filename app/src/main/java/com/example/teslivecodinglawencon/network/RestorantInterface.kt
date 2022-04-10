package com.example.teslivecodinglawencon.network

import com.example.teslivecodinglawencon.data.Restoran
import retrofit2.http.GET

interface RestorantInterface {
   @GET("restaurant/random_restaurant?size=50")
   suspend fun getData(): List<Restoran>
}