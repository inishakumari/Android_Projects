package com.example.storage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        val securePreferences = EncryptedSharedPreferences.create(
            "myfile",
            mainKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        lateinit var sp : SharedPreferences
        var editTextName = findViewById<EditText>(R.id.editName)
        var editTextPass = findViewById<EditText>(R.id.editPassword)
        var submitButton = findViewById<Button>(R.id.buttonSubmit)
        var checkbox = findViewById<CheckBox>(R.id.checkBoxRememberMe)

        var anim = AnimationUtils.loadAnimation(this,R.anim.blink)
        submitButton.startAnimation(anim)


        sp = getSharedPreferences("myfile", MODE_PRIVATE)


        submitButton.setOnClickListener {
            var username = editTextName.text.toString()
            var password = editTextPass.text.toString()
            //var editor = sp.edit()
            var editor = securePreferences.edit()

            if (checkbox.isChecked){
                editor.putString("keyun", username)
                editor.putString("keypass", password)
                editor.commit()
            }
            else{
                editTextName.setText(sp.getString("keyun",""))
                editTextPass.setText(sp.getString("keypass",""))
            }

            //overridePendingTransition(R.anim.blink,R.anim.blink)

        }

    }
}