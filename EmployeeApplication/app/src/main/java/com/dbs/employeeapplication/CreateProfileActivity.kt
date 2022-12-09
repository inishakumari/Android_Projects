package com.dbs.employeeapplication

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
//import androidx.appcompat.app.AlertDialog
import com.dbs.employeeapplication.databinding.ActivityCreateProfileBinding
import java.util.*
import kotlin.collections.ArrayList

class CreateProfileActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{
    private var binding:ActivityCreateProfileBinding ?= null
    val professionalStatus = arrayOf<String?>("Professional Status","Student","Junior Developer","Instructor","Manager","Instructor","Senior Developer")
    /*val skillSet = arrayOf<String>("Java","React","SpringBoot")
    val emptySkill = ArrayList<Int>()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarCreateProfile)
        supportActionBar?.title="Create Profile"
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarCreateProfile?.setNavigationOnClickListener {
            onBackPressed()
        }

        val spin = binding?.spProfessionalStatus
        spin?.onItemSelectedListener=this
        val professionalAdapter : ArrayAdapter<*> = ArrayAdapter<Any?>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,professionalStatus)
        professionalAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        spin?.adapter= professionalAdapter


        //binding?.tvSkillset?.setOnClickListener {


            /*val alertDialogBox = AlertDialog.Builder(this)
            alertDialogBox.setTitle("Select yourrr skill set")

            alertDialogBox.setMultiChoiceItems(skillSet,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

                if(b){
                    emptySkill.add(i)
                }else if (emptySkill.contains(i)){
                    emptySkill.remove(Integer.valueOf(i))
                }

            })*/







           // }


        }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    /*override fun onClick(view: View?) {

        when(view?.id){
            R.id.tvSkillset -> {
                val alertDialogBox = AlertDialog.Builder(this)
                alertDialogBox.setTitle("Select yourrr skill set")

                alertDialogBox.setMultiChoiceItems(skillSet,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

                    if(b){
                        emptySkill.add(i)
                    }else if (emptySkill.contains(i)){
                        emptySkill.remove(Integer.valueOf(i))
                    }

                })
                //alertDialogBox.show()
            }
        }


    }*/



}