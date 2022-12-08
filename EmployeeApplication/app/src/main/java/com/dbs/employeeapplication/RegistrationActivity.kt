package com.dbs.employeeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dbs.employeeapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private var binding:ActivityRegistrationBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarRegister)
        supportActionBar?.title="Registration"
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarRegister?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.btnRegister?.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
}