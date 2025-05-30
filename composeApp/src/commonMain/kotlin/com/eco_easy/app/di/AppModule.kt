package com.eco_easy.app.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            apiModule,
            repositoryModule,
            viewModelModule,
            useCaseModule
        )
    }
}