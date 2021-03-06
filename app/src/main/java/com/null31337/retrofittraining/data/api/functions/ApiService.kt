package com.null31337.retrofittraining.data.api.functions

import com.null31337.retrofittraining.model.functions.Post
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>

    @GET("posts")
    suspend fun getByQueryMap(@QueryMap map: Map<String, String>): Response<List<Post>>

    @PUT("posts/{id}")
    suspend fun putPost(
        @Path("id") id: Int,
        @Body post: Post
    ): Response<Post>

    @POST("posts")
    suspend fun postPost(
        @Body post: Post
    ): Response<Post>

    @DELETE("posts/{id}")
    suspend fun deleteById(
        @Path("id") id: Int
    ): Response<Post>
}