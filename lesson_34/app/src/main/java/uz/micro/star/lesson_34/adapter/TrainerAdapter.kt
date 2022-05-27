package uz.micro.star.lesson_34.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.micro.star.lesson_34.utils.TrainerDiffCallback
import uz.micro.star.lesson_34.databinding.ItemTrainerBinding
import uz.micro.star.lesson_34.dto.TrainerDto
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse

/**
 * Created by Microstar on 20.04.2020.
 */
class TrainerAdapter : RecyclerView.Adapter<TrainerAdapter.PhotoViewHolder>() {
    var _data = mutableListOf<TrainerDto>()

    private var deleteClickListener: ((trainer: TrainerDto, position: Int) -> Unit)? = null

    fun setDeleteClickListener(f: (trainer: TrainerDto, position: Int) -> Unit) {
        deleteClickListener = f
    }

    private var editClickListener: ((trainer: TrainerDto, position: Int) -> Unit)? = null

    fun setEditClickListener(f: (trainer: TrainerDto, position: Int) -> Unit) {
        editClickListener = f
    }

    fun setNewData(newData: List<TrainerDto>) {
        val diff = DiffUtil.calculateDiff(TrainerDiffCallback(_data, newData))
        _data.clear()
        _data.addAll(newData)
        diff.dispatchUpdatesTo(this)
    }

    fun addTrainer(newData: TrainerDto) {
        _data.add(newData)
        notifyItemInserted(_data.size - 1)
    }

    fun editTrainer(newData: TrainerDto, pos: Int) {
        _data[pos] = newData
        notifyItemChanged(pos)
    }

    fun deleteTrainer(pos: Int) {
        _data.removeAt(pos)
        notifyItemRemoved(pos)
    }

    inner class PhotoViewHolder(private val binding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(data: TrainerDto) {
            binding.title.text = data.trainerName
            binding.salary.text = "${data.trainerSalary}"
            binding.edit.setOnClickListener {
                editClickListener?.invoke(data, layoutPosition)
            }
            binding.delete.setOnClickListener {
                deleteClickListener?.invoke(data, layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PhotoViewHolder(
            ItemTrainerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = _data.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
        holder.bindView(_data[position])
}