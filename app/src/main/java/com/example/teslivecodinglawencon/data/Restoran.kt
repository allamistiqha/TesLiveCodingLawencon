package com.example.teslivecodinglawencon.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restoran")
data class Restoran(
    @PrimaryKey val uid : String,
    val name : String,
    val type : String,
    val logo : String,
    val phone_number : String,
    val address : String
)
