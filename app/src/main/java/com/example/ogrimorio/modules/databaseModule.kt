package com.example.ogrimorio.modules

import androidx.room.Room
import com.example.ogrimorio.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = "db_grimorio"
        )
            .addCallback(AppDatabase.SeedCallback(androidContext()))
            .addMigrations()
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()
    }

    factory { get<AppDatabase>().TypeDAO() }
    factory { get<AppDatabase>().CategoryDAO() }
    factory { get<AppDatabase>().CriticalDao() }
}