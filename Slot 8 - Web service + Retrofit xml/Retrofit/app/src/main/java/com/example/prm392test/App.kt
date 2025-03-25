package com.example.prm392test

import android.app.Application
import com.example.prm392test.data.StudentDao
import com.example.prm392test.data.StudentRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {

    // Khởi tạo OkHttpClient với timeout
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // Thời gian chờ kết nối
        .readTimeout(30, TimeUnit.SECONDS) // Thời gian chờ đọc dữ liệu
        .writeTimeout(30, TimeUnit.SECONDS)  // Thời gian chờ ghi dữ liệu
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log toàn bộ request-response
        })
        .build()

    // Khởi tạo Retrofit instance
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/") // Đảm bảo URL đúng
            .client(okHttpClient) // Sử dụng OkHttpClient với timeout
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Khởi tạo DAO
    private val studentDao by lazy {
        retrofit.create(StudentDao::class.java)
    }

    // Khởi tạo Repository
    val studentRepository by lazy {
        StudentRepository(studentDao)
    }

    override fun onCreate() {
        super.onCreate()
        // Có thể thêm các cấu hình khởi tạo khác ở đây
    }
}