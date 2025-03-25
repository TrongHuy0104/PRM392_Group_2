package com.example.prm392test


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prm392test.ui.StudentFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load StudentFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, StudentFragment())
                .commit()
        }
    }
}