package com.example.ogrimorio.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.example.ogrimorio.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreferences(
    private val dataStore: DataStore<Preferences>
) {

    private object Keys {
        val FIRST_USE = booleanPreferencesKey("firstUse")
        val SOUND = booleanPreferencesKey("sound")
        val BACKGROUND = intPreferencesKey("background")
    }

    val firstUse: Flow<Boolean> =
        dataStore.data.map { prefs ->
            prefs[Keys.FIRST_USE] ?: true
        }

    val soundMode: Flow<Boolean> =
        dataStore.data.map { prefs ->
            prefs[Keys.SOUND] ?: true
        }

    val backgroundId: Flow<Int> =
        dataStore.data.map { prefs ->
            prefs[Keys.BACKGROUND] ?: R.drawable.fundo
        }

    suspend fun setSoundMode(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[Keys.SOUND] = enabled
        }
    }

    suspend fun setBackgroundId(id: Int) {
        dataStore.edit { prefs ->
            prefs[Keys.BACKGROUND] = id
        }
    }

    suspend fun setFirstUse(isFirstUse: Boolean) {
        dataStore.edit { prefs ->
            prefs[Keys.FIRST_USE] = isFirstUse
        }
    }

}