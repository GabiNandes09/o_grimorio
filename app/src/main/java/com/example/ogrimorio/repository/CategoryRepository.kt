package com.example.ogrimorio.repository

import com.example.ogrimorio.database.dao.CategoryDAO
import com.example.ogrimorio.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val dao: CategoryDAO
) {

    fun getCategories() : Flow<List<CategoryEntity>> = dao.getAll()
}