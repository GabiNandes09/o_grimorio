package com.example.ogrimorio.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.ogrimorio.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {
    @Insert
    suspend fun insertCategory(category: CategoryEntity) : Long

    @Transaction
    @Query("SELECT * FROM Categories")
    fun getAll() : Flow<List<CategoryEntity>>
}