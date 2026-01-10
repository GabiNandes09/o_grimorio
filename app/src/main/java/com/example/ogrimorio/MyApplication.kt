package com.example.ogrimorio

import android.app.Application
import com.example.ogrimorio.modules.audioModule
import com.example.ogrimorio.modules.dataStoreModule
import com.example.ogrimorio.modules.databaseModule
import com.example.ogrimorio.modules.repositoryModule
import com.example.ogrimorio.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                databaseModule,
                repositoryModule,
                viewModelModule,
                audioModule,
                dataStoreModule
            )
        }
    }
}