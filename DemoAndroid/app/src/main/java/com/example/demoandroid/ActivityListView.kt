package com.example.demoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ActivityListView : AppCompatActivity() {

    var teams = arrayOf("INDIA","GERMANY","US","JAPAN")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var myListView = findViewById<ListView>(R.id.myListView)

        var myadapter = ArrayAdapter(this, R.layout.item_layout, R.id.textViewItem,teams)
        myListView.adapter = myadapter

        myListView.setOnItemClickListener { adapterView, view, pos, id ->
            var item = adapterView.getItemAtPosition(pos).toString()
            Toast.makeText(this, "you clicked $item", Toast.LENGTH_SHORT).show()

        }





    }
}