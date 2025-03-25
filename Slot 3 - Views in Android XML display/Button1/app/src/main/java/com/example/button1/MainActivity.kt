package com.example.button1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the XML layout
        setContentView(R.layout.button_layout)

        // Initialize Button 1
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            Toast.makeText(this, "Button 1 Clicked", Toast.LENGTH_SHORT).show()
        }

        // Initialize Button 2
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            Toast.makeText(this, "Button 2 Clicked", Toast.LENGTH_SHORT).show()
        }

        // Edge case: Disable Button 1 after click
        button1.setOnClickListener {
            Toast.makeText(this, "Button 1 Disabled After Click", Toast.LENGTH_SHORT).show()
            button1.isEnabled = false
        }

        // Edge case: Button 2 long click
        button2.setOnLongClickListener {
            Toast.makeText(this, "Button 2 Long Clicked", Toast.LENGTH_SHORT).show()
            true // Return true to indicate the event was handled
        }
    }
}
