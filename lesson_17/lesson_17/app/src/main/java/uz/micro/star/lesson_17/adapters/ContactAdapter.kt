package uz.micro.star.lesson_17.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.micro.star.lesson_17.databinding.ItemContactBinding
import uz.micro.star.lesson_17.models.Student

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private var contactList = ArrayList<Student>()
    private var deleteListener: ((position: Int) -> Unit)? = null

    fun setDeleteListener(f: (position: Int) -> Unit) {
        deleteListener = f
    }

    fun setAllContacts(list: ArrayList<Student>) {
        contactList.clear()
        contactList.addAll(list)
        notifyDataSetChanged()
    }

    fun addContact(contact: Student) {
        contactList.add(contact)
//        notifyDataSetChanged() bu listni to`liq yangilaydi
        notifyItemInserted(contactList.size - 1)//bu aynan positsiyani yangilaydi
    }

    fun deleteContact(position: Int) {
        contactList.removeAt(position)
//        notifyDataSetChanged()
        notifyItemRemoved(position)
    }

    fun editContact(newContact: Student, position: Int) {
        contactList[position] = newContact
        notifyItemChanged(position)//positsiyadagini yangilaydi
    }

    //-----homework-----//

    //favourite
    // share
    // search
    //call
    //pop up menu


    private var editListener: ((position: Int, name: String, number: String) -> Unit)? = null

    fun setEditListener(f: (position: Int, name: String, number: String) -> Unit) {
        editListener = f
    }

    inner class ContactViewHolder(var binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(contactData: Student) {
            binding.name.text = contactData.name
            binding.number.text = contactData.number
            binding.delete.setOnClickListener {
                deleteListener?.invoke(layoutPosition)
            }
            binding.edit.setOnClickListener {
                editListener?.invoke(layoutPosition, contactData.name, contactData.number)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) =
        holder.bindData(contactList[position])


    override fun getItemCount() = contactList.size
}