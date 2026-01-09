package com.example.ogrimorio.modules

import com.example.ogrimorio.util.SoundEffectPlayer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val audioModule = module {
    single {
        SoundEffectPlayer(
            androidContext()
        )
    }
}