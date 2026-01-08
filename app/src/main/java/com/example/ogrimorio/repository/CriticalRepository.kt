package com.example.ogrimorio.repository

import com.example.ogrimorio.database.dao.CriticalDao
import com.example.ogrimorio.database.dto.CriticalWithRelations
import kotlinx.coroutines.flow.Flow

class CriticalRepository(
    private val dao: CriticalDao
) {
    suspend fun getAllByTypeAndCategory(type: Int, category: Int) : List<CriticalWithRelations> =
        dao.getAllByTypeAndCategory(type, category)
}