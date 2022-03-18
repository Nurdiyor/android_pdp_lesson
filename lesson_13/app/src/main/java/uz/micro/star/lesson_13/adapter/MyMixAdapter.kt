package uz.micro.star.lesson_13.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import uz.micro.star.lesson_13.R
import uz.micro.star.lesson_13.databinding.ItemImageBinding
import uz.micro.star.lesson_13.databinding.ItemMusicBinding
import uz.micro.star.lesson_13.databinding.ItemTextBinding
import uz.micro.star.lesson_13.model.BaseData
import uz.micro.star.lesson_13.model.ImageData
import uz.micro.star.lesson_13.model.MusicData
import uz.micro.star.lesson_13.model.TextData

class MyMixAdapter(var musicList: ArrayList<BaseData>) : BaseAdapter() {

    private var showBalanceClickListener: ((playedPosition: Int) -> Unit)? = null

    fun setOnPlayClickListener(f: (playedPosition: Int) -> Unit) {
        showBalanceClickListener = f
    }

    override fun getCount() = musicList.size

    override fun getItem(p0: Int): BaseData = musicList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        lateinit var binding: ViewBinding
        val data = getItem(position)
        if (data is ImageData) {
            binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            binding.image.setImageResource(data.imgUrl)
            binding.title.text = data.title
        }
        if (data is TextData) {
            binding = ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            binding.title.text = data.title
            binding.content.text = data.content
            binding.dislikeButton.setOnClickListener{
                Toast.makeText(binding.root.context, "Dislike", Toast.LENGTH_SHORT).show()
            }
            binding.likeButton.setOnClickListener{
                Toast.makeText(binding.root.context, "Like", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}