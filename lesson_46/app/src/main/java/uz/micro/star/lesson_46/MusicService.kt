package uz.micro.star.lesson_46

import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
    companion object {
        var instance: MusicService? = null
    }

    // declaring object of MediaPlayer
    private var player: MediaPlayer? = null

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d("OOOO", "onStartCommand: started")
        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        intent.extras?.let {
            val path = it.getString("MUSIC_PATH")
            Log.d("OOOO", "onStartCommand: $path")
            player = MediaPlayer()
            player?.setAudioStreamType(AudioManager.STREAM_MUSIC)
            try {
                player?.setDataSource(path)
                player?.prepare()
            } catch (a: Exception) {
                Log.d("OOOO", "onStartCommand: $a")
            }
            player?.start()
        }
        // returns the status
        // of the program
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // stopping the process
        player?.apply {
            stop()
            release()
            player = null
        }
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