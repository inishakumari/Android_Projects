package com.example.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DemoReceiver : BroadcastReceiver() {
    override fun onReceive(ctx: Context?, intent: Intent?) {
        var data = intent?.getStringExtra("key")
        //Log.i("music",data!!)
        if (data == "Music"){
            var i = Intent(ctx,MyService::class.java)
            ctx?.startService(i)
    }
}}