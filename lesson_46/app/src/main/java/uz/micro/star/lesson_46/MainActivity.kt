package uz.micro.star.lesson_46

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_46.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startService.setOnClickListener {
//            if (!checkServiceRunning(MusicService::class.java)) {
            if (MusicService.instance == null) {
                val intent = Intent(this, MusicService::class.java)
                intent.putExtra("MUSIC_NAME", "yankee")
                startService(intent)
            }
        }
        binding.stopService.setOnClickListener {
            stopService(Intent(this, MusicService::class.java))
        }
    }

    fun checkServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }
}