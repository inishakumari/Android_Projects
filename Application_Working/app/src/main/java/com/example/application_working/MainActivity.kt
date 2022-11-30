package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var submitButton = findViewById<Button>(R.id.buttonSubmit)
        var username = findViewById<EditText>(R.id.editTextUserName)
        var password = findViewById<EditText>(R.id.editTextPassword)

        submitButton.setOnClickListener {
            var username = username.text.toString()
            var password = password.text.toString()

            if (username == "DBS" && password == "123"){
                var myIntent = Intent(this, MainActivity2::class.java)
                myIntent.putExtra("somename", username)
                myIntent.putExtra("somepass", password)
                startActivity(myIntent)
            }
            else{
                Toast.makeText(this,"Credentials are invalid", Toast.LENGTH_LONG).show()
            }

        }
        var textSignup = findViewById<TextView>(R.id.textViewSignup)
        textSignup.setOnClickListener {

            var myIntent = Intent(this,MainActivity4::class.java)
            startActivity(myIntent)

        }

    }
}