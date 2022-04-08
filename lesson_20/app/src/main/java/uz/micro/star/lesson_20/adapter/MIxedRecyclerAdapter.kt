package uz.micro.star.lesson_20.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import uz.micro.star.lesson_20.databinding.ItemImageBinding
import uz.micro.star.lesson_20.databinding.ItemTextBinding
import uz.micro.star.lesson_20.models.BaseModel
import uz.micro.star.lesson_20.models.ImageModel
import uz.micro.star.lesson_20.models.TextModel

class MIxedRecyclerAdapter : RecyclerView.Adapter<MIxedRecyclerAdapter.MixedViewHolder>() {

    private var data = ArrayList<BaseModel>()


    fun setAllData(data: ArrayList<BaseModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class MixedViewHolder(var binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindImage(model: ImageModel) {
            (binding as ItemImageBinding).imageview.setImageResource(model.image)
        }

        fun bindText(model: TextModel) {
            (binding as ItemTextBinding).textview.text = model.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MixedViewHolder(
            if (viewType == 1) ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ) else
                ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MixedViewHolder, position: Int) {
        when (getItemViewType(position)) {
            1 -> {
                holder.bindImage(data[position] as ImageModel)
            }
            2 -> {
                holder.bindText(data[position] as TextModel)
            }
        }
    }

    override fun getItemCount() = data.size

}