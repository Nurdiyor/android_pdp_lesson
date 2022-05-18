package uz.micro.star.lesson_33

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import uz.micro.star.lesson_33.databinding.ActivityMainBinding
import uz.micro.star.lesson_33.mvvm.ActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel = ViewModelProvider(this)[ActivityViewModel::class.java]
//        binding.text1.setOnClickListener {
//            viewmodel.myText.value="${Random().nextInt(999999)}"
//        }
//       viewmodel.myText.observe(this){
//           Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
//       }
        binding.apply {
            btn.setOnClickListener {
                viewmodel.plus(edit1.text.toString().toInt(), edit2.text.toString().toInt())
            }
            viewmodel.plusViewModel.observe(this@MainActivity) {
                answer.text = "$it"
            }
        }
        viewmodel.listViewModel.observe(this) {
//            adapter.setList(it)
        }
        viewmodel.addData()
    }
}