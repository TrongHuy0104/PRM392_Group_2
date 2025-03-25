package com.example.prm392test.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prm392test.data.Student
import com.example.prm392test.data.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository) : ViewModel() {

    val students: LiveData<List<Student>> get() = repository.students
    val loading: LiveData<Boolean> get() = repository.loading

    fun fetchStudents() {
        viewModelScope.launch {
            repository.fetchStudents()
        }
    }
}