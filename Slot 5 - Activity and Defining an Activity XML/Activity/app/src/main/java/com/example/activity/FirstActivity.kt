package com.example.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val edtName = findViewById<EditText>(R.id.edtAge)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val name = edtName.text.toString()
            val ageText = edtAge.text.toString()

            if (name.isNotBlank() && ageText.isNotBlank()) {
                val age = ageText.toInt()
                val user = User(name, age)

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user_data", user)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val edtName by lazy { findViewById<EditText>(R.id.edtName) }
    private val edtAge by lazy { findViewById<EditText>(R.id.edtAge) }
}
