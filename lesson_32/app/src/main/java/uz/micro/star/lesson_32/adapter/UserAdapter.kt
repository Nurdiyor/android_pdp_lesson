package uz.micro.star.lesson_32.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.micro.star.lesson_32.databinding.ItemUserBinding
import uz.micro.star.lesson_32.entities.UserEntity

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var data = mutableListOf<UserEntity>()

    private var onItemClickListener: ((user: UserEntity, position: Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (user: UserEntity, position: Int) -> Unit) {
        onItemClickListener = listener
    }

    fun deleteUser(user: UserEntity, position: Int) {
        data.remove(user)
        notifyItemRemoved(position)
    }

    fun setAllUser(data: List<UserEntity>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(var binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: UserEntity) {
            binding.name.text = data.name
            binding.number.text = data.number
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(data, layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bindData(data[position])

    override fun getItemCount() = data.size
}