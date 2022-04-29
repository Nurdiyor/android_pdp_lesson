package uz.micro.star.lesson_28

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val MY_ACTION = "uz.micro.star.my_message"
    }

    val receiver by lazy {
        ConnectivityStateReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(MY_ACTION)
        }
        registerReceiver(receiver, filter)
        findViewById<TextView>(R.id.text).setOnClickListener {
            sendBroadcast(Intent(MY_ACTION).apply { putExtra("MESSAGE", "HELLO") })
        }
    }

}