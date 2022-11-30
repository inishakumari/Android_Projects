package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var redButton = findViewById<Button>(R.id.buttonRed)
        var blueButton = findViewById<Button>(R.id.buttonBlue)


        redButton.setOnClickListener {
            var redFragment = RedFrag()
            var manager = supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, redFragment)
            transaction.commit()

        }

        blueButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, BlueFrag()).commit()
        }

    }
}