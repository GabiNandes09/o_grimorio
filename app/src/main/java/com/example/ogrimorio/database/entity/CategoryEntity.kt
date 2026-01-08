package com.example.ogrimorio.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.ogrimorio.interfaces.OptionItem

@Entity(
    tableName = "Categories",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Int? = null,
    override val name: String
) : OptionItem
