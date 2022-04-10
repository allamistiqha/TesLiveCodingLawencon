package com.example.teslivecodinglawencon.repository

import androidx.room.withTransaction
import com.example.teslivecodinglawencon.network.DatabaseRestoran
import com.example.teslivecodinglawencon.network.RestorantInterface
import com.example.teslivecodinglawencon.utils.networkBoundResouce
import kotlinx.coroutines.delay
import javax.inject.Inject

class RepositoryData @Inject constructor(
    val restorantInterface: RestorantInterface,
    val databaseRestoran: DatabaseRestoran
) {
    private val restoranDao = databaseRestoran.restoranDao()

    fun getRetoran() = networkBoundResouce(
        query = {
            restoranDao.getData()
        },
        fetch = {
            delay(1500)
            restorantInterface.getData()
        },
        saveFetchResult = {
            databaseRestoran.withTransaction {
                restoranDao.deleteAllData()
                restoranDao.insertData(it)
            }
        }
    )
}