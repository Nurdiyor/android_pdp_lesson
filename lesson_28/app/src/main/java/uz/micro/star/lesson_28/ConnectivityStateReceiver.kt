package uz.micro.star.lesson_28

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log

class ConnectivityStateReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("ZZZZ", "keldi: ${p1!!.action}")
        MediaPlayer.create(p0,R.raw.hmm).start()
        when (p1.action) {
            Intent.ACTION_POWER_CONNECTED -> {
                Log.d("ZZZZ", "onReceive: ACTION_POWER_CONNECTED")
            }
            Intent.ACTION_POWER_DISCONNECTED -> {
                Log.d("ZZZZ", "onReceive: ACTION_POWER_DISCONNECTED")
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                Log.d("ZZZZ", "onReceive: ACTION_AIRPLANE_MODE_CHANGED")
            }
            MainActivity.MY_ACTION->{
                Log.d("ZZZZ", "onReceive: MY_ACTION")
                Log.d("ZZZZ", "onReceive: ${p1.getStringExtra("MESSAGE")}")
            }
        }
    }

}