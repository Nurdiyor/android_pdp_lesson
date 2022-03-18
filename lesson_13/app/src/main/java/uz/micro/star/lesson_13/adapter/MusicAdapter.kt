package uz.micro.star.lesson_13.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import uz.micro.star.lesson_13.R
import uz.micro.star.lesson_13.databinding.ItemMusicBinding
import uz.micro.star.lesson_13.model.MusicData

class MusicAdapter(var musicList: ArrayList<MusicData>) : BaseAdapter() {

    private var showBalanceClickListener: ((playedPosition: Int) -> Unit)? = null

    fun setOnPlayClickListener(f: (playedPosition: Int) -> Unit) {
        showBalanceClickListener = f
    }

    override fun getCount() = musicList.size

    override fun getItem(p0: Int): MusicData = musicList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.headerText.text = getItem(position).musicName
        binding.subText.text = getItem(position).musicAuthor
        binding.image.setImageResource(
            if (!getItem(position).musicIsPlayed)
                R.drawable.ic_baseline_play_arrow_24 else R.drawable.ic_baseline_pause_24
        )
        binding.image.setOnClickListener {
            showBalanceClickListener?.invoke(position)
        }
        return binding.root
    }
}