package com.example.mvi_sample.network

import com.example.mvi_sample.network.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface PostApi {

    suspend fun getPosts(): List<Post>

    companion object {
        private val httpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        // Ignore unknown keys to allow for future API changes
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        fun providePostApi(): PostApi = PostApiImpl(httpClient)
    }
}