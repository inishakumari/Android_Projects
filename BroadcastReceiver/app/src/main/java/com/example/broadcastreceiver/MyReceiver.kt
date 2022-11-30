package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MyReceiver : BroadcastReceiver(), TextToSpeech.OnInitListener
{
    lateinit var tts: TextToSpeech
    lateinit var myMessage : String


    override fun onReceive(ctx: Context?, intent: Intent?) {

        //Toast.makeText(ctx,"Airplanemode on...",Toast.LENGTH_LONG).show()


        Toast.makeText(ctx, "sms received.... ", Toast.LENGTH_LONG).show()
        tts = TextToSpeech(ctx,this)


        var bundle = intent?.extras
        if(bundle != null) {

            var pdusObj = bundle["pdus"] as Array<Any>

            for (i in pdusObj.indices) {
                val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)

                myMessage = currentMessage.displayMessageBody
                tts.speak(myMessage,TextToSpeech.QUEUE_FLUSH,null,"")
                val receiverPh = currentMessage.originatingAddress

                Toast.makeText(
                    ctx,"message is $myMessage and sender is : $receiverPh",Toast.LENGTH_LONG).show()

                Log.i("mytag", "message is $myMessage and sender is : $receiverPh")
            }
        }
    }


    override fun onInit(status: Int) {
        //val myMessage

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                tts?.speak(myMessage, TextToSpeech.QUEUE_FLUSH, null, "")
            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }


    }

}