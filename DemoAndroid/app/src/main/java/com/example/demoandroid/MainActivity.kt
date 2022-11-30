package com.example.demoandroid

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    val channelId = "notifications"
    val description = "Test notification"
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: Notification.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var submitButton = findViewById<Button>(R.id.buttonSubmit)
        var username = findViewById<EditText>(R.id.editTextUsername)
        var usernameTextview = findViewById<TextView>(R.id.textView3)

        registerForContextMenu(usernameTextview)

        Log.i("mytag","main create")
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager



        submitButton.setOnClickListener {

            var myIntent = Intent(this, MainActivity2::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_IMMUTABLE)

            if(Build.VERSION.SDK_INT >= 26){
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)
                notificationBuilder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText("hello Nishaaaa, how are you?")
                    .setContentTitle("Manu")
                    .setContentIntent(pendingIntent)
            }


            notificationManager.notify(1234, notificationBuilder.build())






           /* var username = username.text.toString()
            Log.i("mytag","username is $username")

            var myIntent = Intent(this,MainActivity2::class.java)
            startActivity(myIntent)*/
            /*
            var username = username.text.toString()
            Toast.makeText(this,"username is $username",Toast.LENGTH_LONG).show()
            usernameTextview.setText(username)


            var myIntent = Intent(this,MainActivity2::class.java)
            myIntent.putExtra("somekey",username)

            var user = User("Nisha","123")
            myIntent.putExtra("keyobj",user)*/

            //var myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com"))

            /*var myIntent = Intent(Intent.ACTION_MAIN)
            Intent.CATEGORY_APP_CALCULATOR
            startActivity(myIntent)*/
        }



    }

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        var myid = item.itemId

        if (myid == R.id.mysearch) {
            Toast.makeText(this, "SEARCHING... ", Toast.LENGTH_SHORT).show()

            var builder = AlertDialog.Builder(this)
                .setTitle("My Alert Dialog")
                .setMessage("do you want to exit the App ?")
                .setCancelable(false)
                .setIcon(R.drawable.alertpic_foreground)


                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                    this.finish()
                })
                .setNegativeButton("NO", DialogInterface.OnClickListener { dialogInterface, i ->

                })

            var ad = builder.create()
            ad.show()


        }
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.mymenu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var myid = item.itemId
        if(myid == R.id.mytoast){
            Toast.makeText(this, "context item selected", Toast.LENGTH_SHORT).show()
        }

        return super.onContextItemSelected(item)
    }



    override fun onStart() {
        super.onStart()
        Log.i("mytag","main start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","main resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag","main pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("mytag","main restart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","main stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","main destroy")
    }
}