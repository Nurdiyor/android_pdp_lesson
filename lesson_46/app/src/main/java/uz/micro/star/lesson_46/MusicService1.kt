package uz.micro.star.lesson_46

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService1 : Service() {
    companion object {
        var instance: MusicService1? = null
    }

    // declaring object of MediaPlayer
    private lateinit var player: MediaPlayer

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        intent.extras?.let {
            val name = it.getString("MUSIC_NAME")
            player = MediaPlayer.create(this, resources.getIdentifier(name, "raw", packageName))
            // providing the boolean
            // value as true to play
            // the audio on loop
            player.isLooping = true
            // starting the process
            player.start()
        }
        // returns the status
        // of the program
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // stopping the process
        player.stop()
        instance = null
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}