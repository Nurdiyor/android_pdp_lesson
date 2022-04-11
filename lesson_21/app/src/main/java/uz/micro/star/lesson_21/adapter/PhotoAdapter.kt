package uz.micro.star.lesson_21.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.micro.star.lesson_21.databinding.ItemPhotoBinding
import uz.micro.star.lesson_21.models.response.PhotoResponse

/**
 * Created by Microstar on 20.04.2020.
 */
class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    var _data = mutableListOf<PhotoResponse>()
//    private var clickListener: ((String, String, String, String, Int) -> Unit)? = null
//
//    fun setClickListener(f: (String, String, String, String, Int) -> Unit) {
//        clickListener = f
//    }

    fun setNewData(newData: List<PhotoResponse>) {
//        val diff = DiffUtil.calculateDiff(ServiceDiffUtil(_data, newData))
        _data.clear()
        _data.addAll(newData)
        notifyDataSetChanged()
//        diff.dispatchUpdatesTo(this)
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(data: PhotoResponse) {
            binding.title.text = data.title
            Glide.with(binding.root.context).load("https://ichef.bbci.co.uk/news/640/cpsprodpb/9860/production/_106180093_picasso2.jpg")
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = _data.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
        holder.bindView(_data[position])
}