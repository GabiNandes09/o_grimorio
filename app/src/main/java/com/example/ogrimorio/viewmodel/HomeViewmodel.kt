package com.example.ogrimorio.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ogrimorio.database.entity.CategoryEntity
import com.example.ogrimorio.database.entity.TypeEntity
import com.example.ogrimorio.repository.CategoryRepository
import com.example.ogrimorio.repository.TypeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HomeViewmodel(
    private val typeRepository: TypeRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {
    val types: StateFlow<List<TypeEntity>> =
        typeRepository.getTypes()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    val categories: StateFlow<List<CategoryEntity>> =
        categoryRepository.getCategories()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
}