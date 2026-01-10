package com.example.ogrimorio.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ogrimorio.R
import com.example.ogrimorio.datastore.AppPreferences
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PersonalizeViewModel(
    private val prefs: AppPreferences
) : ViewModel() {
    val sound = prefs.soundMode.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_00),
        initialValue = true
    )

    val backgroundId = prefs.backgroundId.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_00),
        initialValue = R.drawable.fundo
    )

    fun toggleSoundMode(isActive: Boolean) {
        viewModelScope.launch {
            prefs.setSoundMode(isActive)
        }
    }

    fun setBackground(backgroundRes: Int) {
        viewModelScope.launch {
            prefs.setBackgroundId(backgroundRes)
        }
    }
}