package uz.micro.star.lesson_13

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_13.databinding.ActivityFirstBinding
import uz.micro.star.lesson_13.model.Student

class FirstActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnX.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("KEY1", "Hello")
//            intent.putExtra("STUDENT", Student("Aziz", 19))
            intent.putExtra(
                "LIST1", arrayListOf(
                    Student("Xusan", 34),
                    Student("Jamshid", 18),
                    Student("Xasan", 34),
                )
            )
            startActivity(intent)
        }


    }
}