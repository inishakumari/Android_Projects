package com.example.demoandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var username : String, var pwd : String) : Parcelable{

}