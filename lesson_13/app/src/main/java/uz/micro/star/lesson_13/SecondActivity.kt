package uz.micro.star.lesson_13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_13.databinding.ActivitySecondBinding
import uz.micro.star.lesson_13.model.Student

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ext = intent.extras
        ext?.let {
            binding.text1.text = it.getString("KEY1", "")
            it.getSerializable("STUDENT")?.let { std ->
                binding.text2.text = (std as Student).name
            }
        }
        intent.getSerializableExtra("LIST1")?.let { list ->
            binding.text3.text = "${(list as ArrayList<Student>).size}"
        }
    }
}