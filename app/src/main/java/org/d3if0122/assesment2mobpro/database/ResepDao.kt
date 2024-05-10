package org.d3if0122.assesment2mobpro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0122.assesment2mobpro.model.Resep

@Dao
interface ResepDao {
    @Insert
    suspend fun insert(resep: Resep)

    @Update
    suspend fun update(resep: Resep)

    @Query("SELECT * FROM resep ORDER BY tanggal DESC")
    fun getResep(): Flow<List<Resep>>

    @Query("SELECT * FROM resep WHERE id = :id")
    suspend fun getResepById(id: Long): Resep?

    @Query("DELETE FROM resep WHERE id = :id")
    suspend fun deleteById(id: Long)
}