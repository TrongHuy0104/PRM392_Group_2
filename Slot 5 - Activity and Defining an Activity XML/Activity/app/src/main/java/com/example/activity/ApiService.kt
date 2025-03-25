package com.example.activity

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int ): Post

    @GET("posts")
    suspend fun getAllPosts(): List<Post>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): List<Post>

    @POST("posts")
    suspend fun createPost(@Body post: Post): Post
}