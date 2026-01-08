package com.example.ogrimorio.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ogrimorio.database.dao.CategoryDAO
import com.example.ogrimorio.database.dao.TypeDAO
import com.example.ogrimorio.database.entity.CategoryEntity
import com.example.ogrimorio.database.entity.TypeEntity
import com.example.ogrimorio.database.initial_inserts.INITIAL_CATEGORY
import com.example.ogrimorio.database.initial_inserts.INITIAL_TYPE

@Database(
    entities = [
        TypeEntity::class,
        CategoryEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TypeDAO(): TypeDAO
    abstract fun CategoryDAO(): CategoryDAO

    class SeedCallback(
        private val context: Context
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            db.execSQL(INITIAL_TYPE.trimIndent())
            db.execSQL(INITIAL_CATEGORY.trimIndent())
        }
    }
}