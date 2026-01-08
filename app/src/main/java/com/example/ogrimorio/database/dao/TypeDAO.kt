package com.example.ogrimorio.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.ogrimorio.database.entity.TypeEntity

@Dao
interface TypeDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertType(type: TypeEntity)

    @Insert
    suspend fun insertAll(list: List<TypeEntity>)
}