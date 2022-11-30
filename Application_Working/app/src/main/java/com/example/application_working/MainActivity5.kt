package com.example.application_working

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var objResultUsernameTextView = findViewById<TextView>(R.id.textViewUsername1)
        var objResultPasswordTextView = findViewById<TextView>(R.id.textViewPassword1)
        var objResultEmailTextView = findViewById<TextView>(R.id.textViewEmail1)
        var obj = intent.getParcelableExtra<UserData>("keyobj")
        objResultUsernameTextView.text = obj?.username
        objResultPasswordTextView.text = obj?.password
        objResultEmailTextView.text = obj?.email
    }
}