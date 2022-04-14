package uz.micro.star.lesson_22.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.micro.star.lesson_22.databinding.ItemTrainerBinding
import uz.micro.star.lesson_22.models.response.TrainerResponse
import uz.micro.star.lesson_22.utils.TrainerDiffCallback

/**
 * Created by Microstar on 20.04.2020.
 */
class TrainerAdapter : RecyclerView.Adapter<TrainerAdapter.PhotoViewHolder>() {
    var _data = mutableListOf<TrainerResponse>()

    private var deleteClickListener: ((trainer: TrainerResponse, position: Int) -> Unit)? = null

    fun setDeleteClickListener(f: (trainer: TrainerResponse, position: Int) -> Unit) {
        deleteClickListener = f
    }

    private var editClickListener: ((trainer: TrainerResponse, position: Int) -> Unit)? = null

    fun setEditClickListener(f: (trainer: TrainerResponse, position: Int) -> Unit) {
        editClickListener = f
    }

    fun setNewData(newData: List<TrainerResponse>) {
        val diff = DiffUtil.calculateDiff(TrainerDiffCallback(_data, newData))
        _data.clear()
        _data.addAll(newData)
        diff.dispatchUpdatesTo(this)
    }

    fun addTrainer(newData: TrainerResponse) {
        _data.add(newData)
        notifyItemInserted(_data.size - 1)
    }

    fun editTrainer(newData: TrainerResponse, pos: Int) {
        _data[pos] = newData
        notifyItemChanged(pos)
    }

    fun deleteTrainer(pos: Int) {
        _data.removeAt(pos)
        notifyItemRemoved(pos)
    }

    inner class PhotoViewHolder(private val binding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(data: TrainerResponse) {
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