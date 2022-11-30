package com.example.demoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.i("mytag","sec created")

        var resultTextView = findViewById<TextView>(R.id.textViewResult)
        var res = intent.extras?.getString("somekey")
        resultTextView.text = res

        var objResultUsernameTextView = findViewById<TextView>(R.id.textViewObjectUsername)
        var objResultPasswordTextView = findViewById<TextView>(R.id.textViewObjectPassword)
        var obj = intent.getParcelableExtra<User>("keyobj")
        objResultUsernameTextView.text = obj?.username
        objResultPasswordTextView.text = obj?.pwd



    }

    override fun onStart() {
        super.onStart()
        Log.i("mytag","sec start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","sec resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag","sec pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("mytag","sec restart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","sec stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","sec destroy")
    }
}