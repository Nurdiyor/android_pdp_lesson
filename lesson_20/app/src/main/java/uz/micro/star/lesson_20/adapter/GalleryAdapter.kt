package uz.micro.star.lesson_20.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.micro.star.lesson_20.databinding.ItemGaleryBinding
import uz.micro.star.lesson_20.models.GalleryModel

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

     val data = ArrayList<GalleryModel>()

    fun setGalleryData(data: ArrayList<GalleryModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class GalleryViewHolder(var binding: ItemGaleryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: GalleryModel) {
            binding.image.setImageResource(data.image)
            binding.title.text = data.title
            binding.content.text = data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GalleryViewHolder(
            ItemGaleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) =
        holder.bindData(data[position])

    override fun getItemCount() = data.size
}