package com.example.ogrimorio.modules

import com.example.ogrimorio.viewmodel.HomeViewmodel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewmodel(get(), get(), get()) }
}