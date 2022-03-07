package uz.micro.star.lesson_8_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.micro.star.lesson_8_1.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            Thread {
                runOnUiThread {
                    binding.progress.visibility = View.VISIBLE
                }
                val d = getCurrentMoney()
                runOnUiThread {
                    binding.progress.visibility = View.INVISIBLE
                    binding.text1.text = "$d"
                }
            }.start()
        }
    }

    fun getCurrentMoney(): Int {
        val d = 23456
        Thread.sleep(3000)
        return d
    }
}