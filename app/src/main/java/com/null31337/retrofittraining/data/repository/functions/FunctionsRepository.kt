package com.null31337.retrofittraining.data.repository.functions

import com.null31337.retrofittraining.data.api.functions.RetrofitInstance
import com.null31337.retrofittraining.model.functions.Post
import retrofit2.Response
import retrofit2.http.QueryMap

class FunctionsRepository {
    suspend fun getAllPosts(): Response<List<Post>> {
        return RetrofitInstance.api.getAllPosts()
    }

    suspend fun getByQueryMap(@QueryMap map: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getByQueryMap(map)
    }

    suspend fun createPost(post: Post): Response<Post> {
        return RetrofitInstance.api.postPost(post)
    }

    suspend fun putPost(post: Post): Response<Post> {
        return RetrofitInstance.api.putPost(post.id, post)
    }

    suspend fun deleteById(id: Int): Response<Post> {
        return RetrofitInstance.api.deleteById(id)
    }
}
