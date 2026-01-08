package com.example.ogrimorio.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.ogrimorio.database.entity.CategoryEntity

@Dao
interface CategoryDAO {
    @Insert
    suspend fun insertCategory(category: CategoryEntity)
}