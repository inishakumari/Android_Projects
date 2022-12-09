package com.dbs.employeeapplication

import android.app.Application

class EmployeeApp : Application() {

    val db:HistoryDatabase by lazy{
        HistoryDatabase.getInstance(this)
    }
}