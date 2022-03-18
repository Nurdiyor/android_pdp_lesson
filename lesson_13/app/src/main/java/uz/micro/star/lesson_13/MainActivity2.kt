package uz.micro.star.lesson_13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.micro.star.lesson_13.adapter.MyMixAdapter
import uz.micro.star.lesson_13.databinding.ActivityMain2Binding
import uz.micro.star.lesson_13.databinding.ActivityMainBinding
import uz.micro.star.lesson_13.model.BaseData
import uz.micro.star.lesson_13.model.ImageData
import uz.micro.star.lesson_13.model.TextData

class MainActivity2 : AppCompatActivity() {
    lateinit var data:ArrayList<BaseData>
    lateinit var adapter:MyMixAdapter
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        addData()
        adapter= MyMixAdapter(data)
        binding.list.adapter=adapter
    }

    private fun addData() {
        data= ArrayList()
        data.add(TextData("Salom","xayr"))
        data.add(ImageData("Qale",R.drawable.img2))
        data.add(TextData("Salom","xayr"))
        data.add(ImageData("Qale",R.drawable.img1))
        data.add(TextData("Salom","xayr"))
        data.add(ImageData("Qale",R.drawable.img2))
        data.add(TextData("Salom","xayr"))
        data.add(ImageData("Qale",R.drawable.img1))
    }
}