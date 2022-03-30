package com.null31337.retrofittraining.data.repository.functions;

import com.null31337.retrofittraining.model.functions.Post;
import com.null31337.retrofittraining.data.api.functions.RetrofitInstance;
import retrofit2.Response;

class FunctionsRepository {
    suspend fun getAllPosts(): Response<List<Post>> {
        return RetrofitInstance.api.getAllPosts()
    }
    suspend fun createPost(post: Post): Response<Post> {
        return RetrofitInstance.api.postPost(post)
    }
    suspend fun deleteById(id: Int): Response<Post> {
        return RetrofitInstance.api.deleteById(id)
    }
}
