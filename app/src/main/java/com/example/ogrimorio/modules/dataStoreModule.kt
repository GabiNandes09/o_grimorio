package com.example.ogrimorio.modules

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.ogrimorio.datastore.AppPreferences
import com.example.ogrimorio.util.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<Preferences>> {
        androidContext().dataStore
    }

    single {
        AppPreferences(get())
    }
}