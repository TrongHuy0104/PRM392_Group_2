package com.example.prm392test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prm392test.App
import com.example.prm392test.R
import com.example.prm392test.data.StudentAdapter
import com.example.prm392test.ui.viewmodel.StudentViewModel

class StudentFragment : Fragment() {

    private lateinit var viewModel: StudentViewModel
    private lateinit var adapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Lấy instance của App để truy cập repository
        val app = requireActivity().application as App
        val repository = app.studentRepository

        // Khởi tạo ViewModel với repository
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return StudentViewModel(repository) as T
            }
        }).get(StudentViewModel::class.java)

        viewModel.students.observe(viewLifecycleOwner, Observer { students ->
            adapter.submitList(students)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            // Handle loading state
        })

        viewModel.fetchStudents()

        return view
    }
}