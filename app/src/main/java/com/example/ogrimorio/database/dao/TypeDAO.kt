package com.example.ogrimorio.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.ogrimorio.database.entity.TypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TypeDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertType(type: TypeEntity) : Long

    @Insert
    suspend fun insertAll(list: List<TypeEntity>)

    @Transaction
    @Query("SELECT * FROM Types")
    fun getAll() : Flow<List<TypeEntity>>
}