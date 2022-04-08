package uz.micro.star.lesson_20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import uz.micro.star.lesson_20.adapter.GalleryAdapter
import uz.micro.star.lesson_20.databinding.ActivityMain2Binding
import uz.micro.star.lesson_20.models.GalleryModel

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    val adapter by lazy {
        GalleryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewpager.adapter = adapter
        addData()
//        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
//            tab.text = when (position) {
//                0 -> {
//                    "o chi position"
//                }
//                1 -> {
//                    "1 chi position"
//                }
//                2 -> {
//                    "2 chi position"
//                }
//                else -> {
//                    "NImadir"
//                }
//            }
//        }.attach()
        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = adapter.data[position].title
        }.attach()
    }

    private fun addData() {
        val data = ArrayList<GalleryModel>()
        data.add(GalleryModel(R.drawable.one, "Car 1", "v uv yuv yuvyuv uyvuv uvu"))
        data.add(GalleryModel(R.drawable.three, "Car 1", "v uv yuv yuvyuv uyvuv uvu"))
        data.add(GalleryModel(R.drawable.two, "Car 1", "v uv yuv yuvyuv uyvuv uvu"))
        adapter.setGalleryData(data)
    }
}