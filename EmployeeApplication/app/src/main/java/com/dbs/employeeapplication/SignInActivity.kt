package com.dbs.employeeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.dbs.employeeapplication.databinding.ActivityMainBinding
import com.dbs.employeeapplication.databinding.ActivitySignInBinding
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {

    private var binding: ActivitySignInBinding? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarSignin)
        supportActionBar?.title="SignIn"
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarSignin?.setNavigationOnClickListener {
            onBackPressed()
        }


        binding?.btnLogin?.setOnClickListener {
            var email = binding?.etSigninEmail?.text.toString()
            Log.i("Email",email)
            var password = binding?.etSigninPassword?.text.toString()
            Log.i("Email",password)

            if(!(emailValidator(email) && passwordValidator(password))){
                Toast.makeText(this,"Email or Password is Invalid",Toast.LENGTH_LONG).show()
            }
            else{
               val intent = Intent(this,CreateProfileActivity::class.java)
               startActivity(intent)
           }

        }

    }

    fun emailValidator(email : String):Boolean{
        return (!TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())

    }

    fun passwordValidator(password : String):Boolean{
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.matches(password)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}