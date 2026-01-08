package com.example.ogrimorio.repository

import com.example.ogrimorio.database.dao.TypeDAO
import com.example.ogrimorio.database.entity.TypeEntity
import kotlinx.coroutines.flow.Flow

class TypeRepository(
    private val typeDAO: TypeDAO
) {
    fun getTypes() : Flow<List<TypeEntity>> = typeDAO.getAll()
}