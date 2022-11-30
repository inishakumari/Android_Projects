package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        var username = findViewById<EditText>(R.id.editTextUserName).text.toString()
        var password = findViewById<EditText>(R.id.editTextPassword).text.toString()
        var email = findViewById<EditText>(R.id.editTextEmail).text.toString()

        var register = findViewById<Button>(R.id.buttonRegister)

        register.setOnClickListener {

            var myIntent = Intent(this,MainActivity5::class.java)

            var userData = UserData(username,password,email)
            myIntent.putExtra("keyobj",userData)

            startActivity(myIntent)
        }









    }
}