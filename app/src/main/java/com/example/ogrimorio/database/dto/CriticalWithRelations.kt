package com.example.ogrimorio.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.example.ogrimorio.database.entity.CategoryEntity
import com.example.ogrimorio.database.entity.CriticalEntity
import com.example.ogrimorio.database.entity.TypeEntity

data class CriticalWithRelations(
    @Embedded val critical: CriticalEntity,

    @Relation(
        parentColumn = "type_id",
        entityColumn = "id"
    )
    val type: TypeEntity,

    @Relation(
        parentColumn = "category_id",
        entityColumn = "id"
    )
    val category: CategoryEntity
)

