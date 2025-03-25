package com.example.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val tvResult by lazy { findViewById<TextView>(R.id.tvResult) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val user = intent.getParcelableExtra<User>("user")
        user?.let {
            val resultText = "Name: ${it.name}\nAge: ${it.age}"
            tvResult.text = resultText
        } ?: run {
            tvResult.text = "No data received!"
        }
    }
}
