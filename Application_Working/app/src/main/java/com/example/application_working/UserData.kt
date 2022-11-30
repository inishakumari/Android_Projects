package com.example.application_working

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(var username : String, var password : String, var email : String, ) : Parcelable{

}