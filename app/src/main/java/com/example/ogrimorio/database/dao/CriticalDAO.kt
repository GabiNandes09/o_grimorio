package com.example.ogrimorio.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.ogrimorio.database.dto.CriticalWithRelations
import com.example.ogrimorio.database.entity.CriticalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CriticalDao {

    @Transaction
    @Query("SELECT * FROM Criticals")
    suspend fun getAllWithRelations(): List<CriticalWithRelations>

    @Transaction
    @Query("""
        SELECT * FROM Criticals
        WHERE type_id = :typeId
          AND category_id = :categoryId
    """)
    suspend fun getAllByTypeAndCategory(
        typeId: Int,
        categoryId: Int
    ): List<CriticalWithRelations>

    @Insert
    suspend fun insert(critical: CriticalEntity) : Long
}
