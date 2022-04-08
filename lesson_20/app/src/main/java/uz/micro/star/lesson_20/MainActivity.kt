package uz.micro.star.lesson_20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.micro.star.lesson_20.adapter.MIxedRecyclerAdapter
import uz.micro.star.lesson_20.databinding.ActivityMainBinding
import uz.micro.star.lesson_20.models.BaseModel
import uz.micro.star.lesson_20.models.ImageModel
import uz.micro.star.lesson_20.models.TextModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val adapter by lazy {
        MIxedRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        addData()
    }

    private fun addData() {
        val data = ArrayList<BaseModel>()
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hello"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hi"))
        data.add(TextModel("GO"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hello"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hi"))
        data.add(TextModel("GO"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hello"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hi"))
        data.add(TextModel("GO"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hello"))
        data.add(ImageModel(R.drawable.ic_launcher_background))
        data.add(TextModel("Hi"))
        data.add(TextModel("GO"))
        adapter.setAllData(data)
    }
}