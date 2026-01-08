package com.example.ogrimorio.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Criticals",
    foreignKeys = [
        ForeignKey(
            entity = TypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["type_id"],
            onDelete = ForeignKey.RESTRICT
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index("type_id"),
        Index("category_id")
    ]
)
data class CriticalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val name: String,
    val effect: String,

    @ColumnInfo(name = "type_id")
    val typeId: Int,

    @ColumnInfo(name = "category_id")
    val categoryId: Int
)
