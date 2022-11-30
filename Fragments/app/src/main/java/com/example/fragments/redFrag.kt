package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class RedFrag : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.red_layout, container, false)



        var redBut = view.findViewById<Button>(R.id.buttonRed)
        redBut.setOnClickListener {

            var name = view.findViewById<TextView>(R.id.editTextNameRed).text.toString()
            var pass = view.findViewById<TextView>(R.id.editTextPasswordRed).text.toString()


            var bundle = Bundle()
            bundle.putString("key1",name)
            bundle.putString("key2",pass)

            var blueFrag = BlueFrag()
            blueFrag.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.dynamicFrag, blueFrag)?.addToBackStack(null)?.commit()
        }

        return view
    }
}