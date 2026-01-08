package com.example.ogrimorio.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class TypeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
)
