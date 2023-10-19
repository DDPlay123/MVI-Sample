package com.example.mvi_sample.network

import com.example.mvi_sample.network.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class PostApiImpl(
    private val httpClient: HttpClient
): PostApi {

    override suspend fun getPosts(): List<Post> {
        return httpClient.get {
            url("https://jsonplaceholder.typicode.com/posts")
        }.body<List<Post>>()
    }


}