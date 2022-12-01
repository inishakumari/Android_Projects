package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    lateinit var myUserList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myRecyclerView = findViewById<RecyclerView>(R.id.myrv)
        myRecyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        myUserList = ArrayList<User>()
        var myAdapter = MyAdapter(myUserList)
        myRecyclerView.adapter = myAdapter

        addUserData()
    }



    private fun addUserData() {

        var u1 = User("Varun", "123")
        myUserList.add(u1)

        var u2 = User("Manu", "321")
        myUserList.add(u2)

        var u3 = User("Jay", "777")
        myUserList.add(u3)

        var u4 = User("Simran", "143")
        myUserList.add(u4)

        var u5 = User("Pandu", "123")
        myUserList.add(u5)

        var u6 = User("lmcmephgbc", "123")
        myUserList.add(u6)

    }
}