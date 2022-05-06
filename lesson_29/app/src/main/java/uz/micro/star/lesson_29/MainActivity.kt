package uz.micro.star.lesson_29

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_29.databinding.ActivityMainBinding
import uz.micro.star.lesson_29.notifications.MyNotification
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var bindind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)
//        val typeface: Typeface? = ResourcesCompat.getFont(this, R.font.water_regular)
        val typeface=Typeface.createFromAsset(assets, "fonts/water_regular.ttf")
//        val typeface: Typeface = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            resources.getFont(R.font.water_regular)
//        } else {
//            TODO("VERSION.SDK_INT < O")
//        }
        bindind.customFont.typeface = typeface
        //notification
        val notification=MyNotification()
        notification.createNotificationChannel(this)
        intent.getStringExtra("FRAGMENT_NAME")?.let {
            bindind.customFont.text=it
        }

        bindind.customFont.setOnClickListener {
            notification.manager.notify(
               System.currentTimeMillis().toInt(),
                notification.createNotification(this,"Hello","This is my notification")
            )
        }
    }

}