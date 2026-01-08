package com.example.ogrimorio.modules

import com.example.ogrimorio.repository.CategoryRepository
import com.example.ogrimorio.repository.TypeRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { TypeRepository(get()) }
    factory { CategoryRepository(get()) }
}