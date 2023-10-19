package com.example.mvi_sample

import com.example.mvi_sample.network.model.Post

data class PostState(
    val progressBar: Boolean = false,
    val posts: List<Post> = emptyList()
)