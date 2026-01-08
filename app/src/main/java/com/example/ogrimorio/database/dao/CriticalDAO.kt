package com.example.ogrimorio.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.ogrimorio.database.dto.CriticalWithRelations
import com.example.ogrimorio.database.entity.CriticalEntity

@Dao
interface CriticalDao {

    @Transaction
    @Query("SELECT * FROM critical")
    suspend fun getAllWithRelations(): List<CriticalWithRelations>

    @Insert
    suspend fun insert(critical: CriticalEntity) : Long
}
