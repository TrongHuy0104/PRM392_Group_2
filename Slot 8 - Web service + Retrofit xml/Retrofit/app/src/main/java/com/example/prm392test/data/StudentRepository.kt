package com.example.prm392test.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StudentRepository(private val studentDao: StudentDao) {

    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> get() = _students

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    suspend fun fetchStudents() {
        _loading.value = true
        try {
            val response = studentDao.getStudents()
            if (response.isSuccessful) {
                _students.value = response.body()?.data
            } else {
                // Xử lý lỗi khi API trả về mã lỗi (ví dụ: 404, 500)
                val errorMessage = "Error: ${response.code()} - ${response.message()}"
                Log.e("API_ERROR", errorMessage)
            }
        } catch (e: Exception) {
            // Xử lý lỗi mạng hoặc lỗi khác
            Log.e("NETWORK_ERROR", e.message ?: "Unknown error")
        } finally {
            _loading.value = false
        }
    }
}