package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var usernameTextView = findViewById<TextView>(R.id.textViewUsername)
        var passwordTextView = findViewById<TextView>(R.id.textViewPassword)
        var res1 = intent.extras?.getString("somename")
        var res2 = intent.extras?.getString("somepass")
        usernameTextView.text = res1
        passwordTextView.text = res2

        var home = findViewById<Button>(R.id.buttonHome)
        home.setOnClickListener {

            var myIntent = Intent(this,MainActivity::class.java)
            startActivity(myIntent)

        }

        var next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {

            var myIntent = Intent(this,MainActivity3::class.java)
            startActivity(myIntent)

        }


    }
}