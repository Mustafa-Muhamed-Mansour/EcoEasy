package com.eco_easy.app.di

import com.eco_easy.app.network.remote.ApiService
import com.eco_easy.app.network.datasource.remote.KtorClient
import org.koin.dsl.module

val apiModule = module {
    single { ApiService(client = KtorClient.httpClient) }
}