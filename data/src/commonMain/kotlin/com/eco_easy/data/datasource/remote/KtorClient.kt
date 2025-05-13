package com.eco_easy.data.datasource.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            })
        }

        install(HttpTimeout) {
            connectTimeoutMillis = 3000
            requestTimeoutMillis = 3000
            socketTimeoutMillis = 3000
        }
    }
}