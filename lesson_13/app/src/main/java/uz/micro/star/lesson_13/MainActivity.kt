package uz.micro.star.lesson_13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import uz.micro.star.lesson_13.adapter.MusicAdapter
import uz.micro.star.lesson_13.databinding.ActivityMainBinding
import uz.micro.star.lesson_13.model.MusicData

class MainActivity : AppCompatActivity() {
    private lateinit var searchedMusicList: ArrayList<MusicData>
    private lateinit var musicList: ArrayList<MusicData>
    private lateinit var adapter: MusicAdapter
    private var lastPosition: Int = -1
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAllMusic()
        adapter = MusicAdapter(searchedMusicList)
        binding.list.adapter = adapter
        adapter.setOnPlayClickListener { currentPosition ->
            if (lastPosition > -1) {
                searchedMusicList[lastPosition].musicIsPlayed = false
            }
            if (lastPosition == currentPosition) {
                lastPosition = -1
            } else {
                Toast.makeText(this, "ELSE", Toast.LENGTH_SHORT).show()
                searchedMusicList[currentPosition].musicIsPlayed = true
                lastPosition = currentPosition
            }
            adapter.notifyDataSetChanged()
        }
        binding.musicSearch.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                val searchedList = musicList.filter { music ->
                    music.musicName.lowercase().contains(it.toString().lowercase())
                }
//                musicList.forEach { music ->
//                    if (music.musicName.contains(it.toString())) {
//                        searchedMusicList.add(music)
//                    }
//                }
                searchedMusicList.clear()
                if (searchedList.isNotEmpty()) {
                    searchedMusicList.addAll(searchedList)
                    adapter.notifyDataSetChanged()
                } else {
                    searchedMusicList.addAll(musicList)
                    adapter.notifyDataSetChanged()
                }
            } else {
                searchedMusicList.clear()
                searchedMusicList.addAll(musicList)
                adapter.notifyDataSetChanged()
            }
        }

    }

    private fun setAllMusic() {
        musicList = ArrayList()
        musicList.add(MusicData("Yomg`ir", "Munisa Rizayeva"))
        musicList.add(MusicData("Gulbadan", "Sherali Jo`rayev"))
        musicList.add(MusicData("Chaqasan", "Jahongir Otajonov"))
        musicList.add(MusicData("BIr qadam", "Ozoda opa"))
        musicList.add(MusicData("Yomg`ir", "Munisa Rizayeva"))
        musicList.add(MusicData("Gulbadan", "Sherali Jo`rayev"))
        musicList.add(MusicData("Chaqasan", "Jahongir Otajonov"))
        musicList.add(MusicData("BIr qadam", "Ozoda opa"))
        searchedMusicList = ArrayList()
        searchedMusicList.addAll(musicList)
    }
}