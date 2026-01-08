package com.example.ogrimorio.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ogrimorio.database.dto.CriticalWithRelations
import com.example.ogrimorio.database.entity.CategoryEntity
import com.example.ogrimorio.database.entity.TypeEntity
import com.example.ogrimorio.repository.CategoryRepository
import com.example.ogrimorio.repository.CriticalRepository
import com.example.ogrimorio.repository.TypeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewmodel(
    private val typeRepository: TypeRepository,
    private val categoryRepository: CategoryRepository,
    private val criticalRepository: CriticalRepository
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

    private val _criticalRolled = MutableStateFlow<CriticalWithRelations?>(null)
    val criticalRolled: StateFlow<CriticalWithRelations?> = _criticalRolled.asStateFlow()

    fun makeARoll(
        type: Int,
        category: Int
    ) =
        viewModelScope.launch {
            val list = criticalRepository.getAllByTypeAndCategory(type, category)
            _criticalRolled.value =
                if (list.isNotEmpty()) list.random() else null
        }

    fun rollReset() {
        _criticalRolled.value = null
    }
}