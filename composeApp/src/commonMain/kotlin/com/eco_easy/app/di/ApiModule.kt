package com.eco_easy.app.di

import com.eco_easy.data.datasource.remote.ApiService
import com.eco_easy.data.datasource.remote.KtorClient
import org.koin.dsl.module

val apiModule = module {
    single { ApiService(client = KtorClient.httpClient) }
}