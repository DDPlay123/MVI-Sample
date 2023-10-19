package com.example.mvi_sample

import com.example.mvi_sample.network.PostApi
import com.example.mvi_sample.network.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPosts(
    private val postApi: PostApi
) {

    fun execute(): Flow<DataState<List<Post>>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val posts = postApi.getPosts()
                emit(DataState.Success(posts))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(DataState.Error(UIComponent.Toast(e.message ?: "Unknown Error")))
            } finally {
                emit(DataState.Loading(false))
            }
        }
    }
}