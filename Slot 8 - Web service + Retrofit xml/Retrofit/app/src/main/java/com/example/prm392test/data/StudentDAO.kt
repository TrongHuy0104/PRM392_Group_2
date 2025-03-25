package com.example.prm392test.data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentDao {
    @GET("api/users?page=1")
    suspend fun getStudents(): Response<ApiResponse>
}